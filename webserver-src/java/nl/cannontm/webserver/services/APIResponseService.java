package nl.cannontm.webserver.services;

import jakarta.transaction.Transactional;
import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.ProcessTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class APIResponseService {



        public Clan processClanData(Clan clan){

                String tag = clan.getTag();
                String name = clan.getName();

                System.out.println("I'm being Called!");
                /*
                       update clandata, check memberlist
                       -> onPlayerJoin(Player)
                       -> onPlayerLeft(Player)

                 */

                return clan;
        }



}
