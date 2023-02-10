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

        List<ProcessTask> Queue = new ArrayList<>();


        public void enqueue(Player player, String reason){
                Queue.add(new ProcessTask(player,reason));
        }

        public void dequeue(int id){
                Queue.remove(0);
        }

        public ProcessTask getQueueIndex(int id){

                if(Queue.isEmpty())return null;

                try {
                        return Queue.get(id);
                }
                catch(Exception e){
                        System.err.println("attempt to grab an non existing place in the queue: place " + id + " Where size is " + Queue.size());
                        return null;
                }
        }

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
