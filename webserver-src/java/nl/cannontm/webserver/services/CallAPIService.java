package nl.cannontm.webserver.services;

import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.ProcessTask;
import nl.cannontm.webserver.singleton.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class CallAPIService {

    @Autowired
    SchedulerService schedulerService;

    @Value("${coc_token}")
    private String coc_token;

   // @Scheduled(cron = "0 */10 * * * *")
    public synchronized Clan getClan(String tag) {

        ;
        URI url = URI.create("https://api.clashofclans.com/v1/clans/%23" + tag.substring(1));
        return WebClient.create()
                .get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(coc_token))
                .retrieve()
                .bodyToMono(Clan.class)
                .map(clan -> {
                    String tag1 = clan.getTag();
                    String name = clan.getName();
                    System.out.println(clan.getName());
                    Set<Player> memberList = Arrays.stream(clan.getMemberList().toArray(Player[]::new)).map(player -> {
                        String tag2 = player.getTag();
                        String name1 = player.getName();
                        return new Player(tag2,name1);
                    }).collect(Collectors.toSet());
                    Clan clan2 = new Clan(tag1, name, memberList);
                    return processClanData(clan2);
                }).block();

    }

    // @Scheduled(cron = "0 * * * * *")
    public Player getPlayer(String tag) {

            String url = "https://api.clashofclans.com/v1/players/%23" + tag.substring(1);

        return WebClient.create()
                .get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(coc_token))
                .retrieve()
                .bodyToMono(Player.class)
                .map(player -> {
                    String tag1 = player.getTag();
                    String name = player.getName();
                    Integer th = player.getTownHallLevel();


                    return new Player(tag1, name);
                }).block();

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
