package nl.cannontm.webserver.services;

import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.ClanMember;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.ProcessTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class CallAPIService {

    @Autowired
    APIResponseService apiResponseService;

    @Value("${coc_token}")
    private String coc_token;

   // @Scheduled(cron = "0 */10 * * * *")
    public synchronized Clan callClanAPI() {

        URI url = URI.create("https://api.clashofclans.com/v1/clans/%2328UC9CQ9V");
        return WebClient.create()
                .get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(coc_token))
                .retrieve()
                .bodyToMono(Clan.class)
                .map(clan -> {
                    String tag = clan.getTag();
                    String name = clan.getName();
                    Integer members = clan.getMembers();
                    System.out.println(clan.getName());
                    Set<Player> memberList = Arrays.stream(clan.getMemberList().toArray(Player[]::new)).map(player -> {
                        String tag1 = player.getTag();
                        String name1 = player.getName();
                        return new Player(tag1,name1);
                    }).collect(Collectors.toSet());
                    Clan clan2 = new Clan(tag, name, members, memberList);
                    return processClanData(clan2);
                }).block();

    }

    // @Scheduled(cron = "0 * * * * *")
    public synchronized void callPlayerAPI() {

        ProcessTask processTask = apiResponseService.getQueueIndex(0);
        if(processTask != null){
            String tag = processTask.getPlayer().getTag();

            String url = "https://api.clashofclans.com/v1/players/" + tag;


        }
    }




    public Clan processClanData(Clan clan){

        String tag = clan.getTag();
        String name = clan.getName();

        System.out.println(tag + " :  " + name);
        for (Player member : clan.getMemberList()){
            System.out.println("Member: " + member.getName());
        }

        System.out.println("I'm being Called!");
                /*
                       update clandata, check memberlist
                       -> onPlayerJoin(Player)
                       -> onPlayerLeft(Player)

                 */

        return clan;
    }


}
