package nl.cannontm.webserver.services;

import jakarta.transaction.Transactional;
import nl.cannontm.webserver.config.BotConfig;
import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Notitions;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.ProcessTask;
import nl.cannontm.webserver.singleton.Queue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    CallAPIService callAPIService;

    @Autowired
    PlayerService playerService;

    @Autowired
    ClanService clanService;

    @Autowired
    ProgressService progressService;

    @Autowired
    NotitionsService notitionsService;


        @Scheduled(fixedRate = 1000*10)
       private void QueueCheck(){


            if(Queue.getInstance().isEmpty()){
                BotConfig.setQueueShowChannel(0);
                return;
            }


            int id = Queue.getInstance().getIdWithPriority();

            ProcessTask task = Queue.getInstance().getQueueIndex(id);
            BotConfig.log("Queue Size: " + Queue.getInstance().getQueueSize() + " , parts: " + Queue.getInstance().getQueueParts() + " , Task: " + task.getTaskType() + " , tag: " + task.getTag() + " , Reason: " + task.getReason() + " , priority: " + task.getPriority());
            if(task.getTaskType().equals("clan")){
               handleClan(task);

            }
            else if(task.getTaskType().equals("player")){
                handlePlayer(task);

            }

            Queue.getInstance().dequeue(id);
            BotConfig.setQueueShowChannel(Queue.getInstance().getQueueSize());
       }

    @Scheduled(fixedRate = 5*1000*60)
    private void dateCheck(){ //keeps track of outdated date and will add players/clans with outdated data to the queue so data will be refreshed
        List<Player> players = playerService.getUpdatablePlayers();
        List<Clan> clans = clanService.getAllClans();

        players.forEach(player -> Queue.getInstance().enqueue("player", player.getTag(), "updating", 0));
        clans.forEach(clan -> Queue.getInstance().enqueue("clan", clan.getTag(), "joinLeaveCheck", 4));


    }




    public void handleClan(ProcessTask task){
        Clan clan = callAPIService.getClan(task.getTag());


        List<String> oldPlayerData = new ArrayList<>(Queue.getInstance().getPlayersInClan(task.getTag()));
        List<String> playerDataSaved = new ArrayList<>();
        List<String> newPlayerData = new ArrayList<>();

        for(Player player : clan.getMemberList()){
            newPlayerData.add(player.getTag());
            playerDataSaved.add(player.getTag());
        }
        System.out.println("OldPlayer data: " + oldPlayerData.size() + " , newPlayer data: " + newPlayerData.size());
        if(oldPlayerData.isEmpty()){ //happends when data is missing, not a full clan that's popping up in the join log.
            Queue.getInstance().setPlayerOfClan(task.getTag(), playerDataSaved);
            onPlayerAction(newPlayerData, "missing", 1, "adding missing clan to Queue: " + newPlayerData.size() + " players", task.getTag());
            return;
        }

        oldPlayerData.removeAll(newPlayerData);
        newPlayerData.removeAll(Queue.getInstance().getPlayersInClan(task.getTag()));
        Queue.getInstance().setPlayerOfClan(task.getTag(), playerDataSaved);
        if (!newPlayerData.isEmpty()){
            onPlayerAction(newPlayerData, "joining", 3, "Adding " + newPlayerData.size() + " joining player(s) to Queue.", task.getTag());

        }
        if (!oldPlayerData.isEmpty()){

            onPlayerLeft(oldPlayerData, clan.getName());

        }

        List<Player> outdatedPlayers = playerService.getUpdatablePlayers();
        if(!outdatedPlayers.isEmpty()){
            BotConfig.log("adding " + outdatedPlayers.size() + " outdated Players to the Queue");
            outdatedPlayers.forEach(player -> Queue.getInstance().enqueue("player", player.getTag(), "updating", 0));
        }

    }


    public void onPlayerAction(List<String> playerlist,String action, int priority, String log, String clanTag){


        for (String tag : playerlist){
            Player player = playerService.getPlayerFromTag(tag);
            if(player == null){

                Queue.getInstance().enqueue("player", tag, action, 3);
            }
            else{
                if(action.equals("missing")){
                    if(player.getClanTag().equals(clanTag)){
                        long time = System.currentTimeMillis() - player.getDate_check();
                        long hours = time/(3600*1000);
                        if(time < 12*3600*1000){
                            System.out.println("Player " + player.getName() + " has not changed clan and was updated just " + hours + " hours and " + ((time - hours*3600*1000)/(1000*60)) + " minutes ago.");
                        }
                        else{
                            Queue.getInstance().enqueue("player", tag, action, priority);
                        }
                    }
                }
                else{
                    Queue.getInstance().enqueue("player", tag, action, priority);
                }
            }

        }
        BotConfig.log(log);
    }
    public void onPlayerLeft(List<String> playerlist, String clanName){
            String log = "";

            for (String tag : playerlist){
                Player player = playerService.getPlayerFromTag(tag);
                log = log + ", " + player.getName();

            }
            BotConfig.onPlayerLeft(log.substring(2) + " Left " + clanName);

    }

    public void handlePlayer(ProcessTask task){
        Player player = callAPIService.getPlayer(task.getTag());
        Clan clan = clanService.getClanFromTag(player.getClanTag());
        playerService.updatePlayer(clan, player);
        progressService.updateProgress(task.getTag());
        if(task.getReason().equals("joining")){
            List<Notitions> notitions = new ArrayList<>();
            notitionsService.getAllNotitionsByTag(player.getTag()).forEach(notitions::add);
            BotConfig.onPlayerJoin(player, clan, notitions);
        }


    }


}
