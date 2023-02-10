package nl.cannontm.webserver.singleton;


import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.ProcessTask;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private static Queue INSTANCE;

    private static List<ProcessTask> list = new ArrayList<>();

    public synchronized static Queue getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new Queue();
        }
        return INSTANCE;
    }

    private Queue(){}

    public void enqueue(Player player, String reason){
        list.add(new ProcessTask(player,reason));
    }

    public void dequeue(int id){
        list.remove(0);
    }

    public ProcessTask getQueueIndex(int id){

        if(list.isEmpty())return null;

        try {
            return list.get(id);
        }
        catch(Exception e){
            System.err.println("attempt to grab an non existing place in the queue: place " + id + " Where size is " + list.size());
            return null;
        }
    }

}

