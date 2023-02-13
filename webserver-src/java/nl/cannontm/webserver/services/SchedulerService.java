package nl.cannontm.webserver.services;

import jakarta.transaction.Transactional;
import nl.cannontm.webserver.config.BotConfig;
import nl.cannontm.webserver.models.Clan;
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


        @Scheduled(fixedRate = 1000*20)
       private void QueueCheck(){
            if(Queue.getInstance().isEmpty()){
                System.out.println("de Queue is leeg");
                return;
            }


            int id = Queue.getInstance().getIdWithPriority();

            ProcessTask task = Queue.getInstance().getQueueIndex(id);
            BotConfig.log("Queue Size: " + Queue.getInstance().getQueueSize() + " , Task: " + task.getTaskType() + " , tag: " + task.getTag() + " , Reason: " + task.getReason() + " , priority: " + task.getPriority());
            if(task.getTaskType().equals("clan")){
               handleClan(task);

            }
            else if(task.getTaskType().equals("player")){
                handlePlayer(task);

            }

            Queue.getInstance().dequeue(id);
       }

    @Scheduled(fixedRate = 3*1000*60)
    private void dateCheck(){ //keeps track of outdated date and will add players/clans with outdated data to the queue so data will be refreshed
        List<Player> players = playerService.getUpdatablePlayers();
        List<Clan> clans = clanService.getAllClans();

        players.forEach(player -> Queue.getInstance().enqueue("player", player.getTag(), "updating", 0));
        clans.forEach(clan -> Queue.getInstance().enqueue("clan", clan.getTag(), "joinLeaveCheck", 2));


    }


    public void handleClan(ProcessTask task){
        Clan clan = callAPIService.getClan(task.getTag());


        List<String> oldPlayerData = new ArrayList<>(Queue.getInstance().getPlayersInClan(task.getTag()));

        List<String> newPlayerData = new ArrayList<>();
        for(Player player : clan.getMemberList()){
            newPlayerData.add(player.getTag());
        }

        if(oldPlayerData.isEmpty()){ //happends when data is missing, not a full clan that's popping up in the join log.
            onPlayerAction(newPlayerData, "missing", 1, "adding missing clan to Queue: " + newPlayerData.size() + " players");
            return;
        }

        oldPlayerData.removeAll(newPlayerData);
        newPlayerData.removeAll(Queue.getInstance().getPlayersInClan(task.getTag()));

        if (!newPlayerData.isEmpty()){
            onPlayerAction(newPlayerData, "joining", 4, "Adding " + newPlayerData.size() + " joining player(s) to Queue.");

        }
        if (!oldPlayerData.isEmpty()){

            onPlayerLeft(oldPlayerData);

        }


    }


    public void onPlayerAction(List<String> playerlist,String action, int priority, String log){


        for (String tag : playerlist){
            Queue.getInstance().enqueue("player", tag, action, priority);
        }
        BotConfig.log(log);
    }
    public void onPlayerLeft(List<String> playerlist){
            String log = "";

            for (String tag : playerlist){
                Player player = playerService.getPlayerFromTag(tag);
                log = log + ", " + player.getName();
            }
            BotConfig.log(log.substring(2) + " Left");

    }

    public void handlePlayer(ProcessTask task){
        Player player = callAPIService.getPlayer(task.getTag());
        Clan clan = clanService.getClanFromTag(player.getClanTag());
        System.out.println("Clan of Player " + player.getName() + "Received from database");
        Player dbPlayer = playerService.updatePlayer(clan, player);

        if(task.getReason().equals("joining")){
            BotConfig.onPlayerJoin(player);
        }
        System.out.println("Task Done: " + task.getTaskType() + "Reason: " + task.getReason());

    }


}
