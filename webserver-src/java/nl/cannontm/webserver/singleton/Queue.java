package nl.cannontm.webserver.singleton;


import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.ProcessTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queue {

    private static Queue INSTANCE;

    private static List<ProcessTask> list = new ArrayList<>();

    private static Map<String, List<String>> clanMap = new HashMap<>();

    public synchronized static Queue getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new Queue();
        }
        return INSTANCE;
    }

    private Queue(){}

    public void enqueue(String type, String tag, String reason, int priority){
        boolean flag = false;
        for (ProcessTask processTask : list){
            if(processTask.getTag().equals(tag)){
                flag = true;
            }
        }
        if(!flag){
            list.add(new ProcessTask(type, tag,reason, priority));
        }

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

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int getIdWithPriority(){
        int theID = 0;
        int highestPriority = 0;

        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getPriority() > highestPriority){
                theID = i;
                highestPriority = list.get(i).getPriority();
            }
        }

        return theID;
    }

    public List<String> getPlayersInClan(String clantag){
        if(clanMap.get(clantag) == null){
            AddClan(clantag);
            return clanMap.get(clantag);
        }
        else{
            return clanMap.get(clantag);
        }
    }

    public int getQueueSize(){
        return list.size();
    }

    public void AddClan(String clantag){
        clanMap.put(clantag, new ArrayList<>());
    }

    public void removeClan(String tag){
        clanMap.remove(tag);
    }

    public void setPlayerOfClan(String clantag, List<String> playerlist){

        clanMap.replace(clantag, playerlist);
    }




}

