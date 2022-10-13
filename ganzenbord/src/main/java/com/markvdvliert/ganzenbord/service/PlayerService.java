package com.markvdvliert.ganzenbord.service;

import com.markvdvliert.ganzenbord.database.GameDB;
import com.markvdvliert.ganzenbord.model.EnumStatus;
import com.markvdvliert.ganzenbord.model.Player;

public class PlayerService {

    public void addPlayer(String name, String color){
        GameDB.players.add(new Player(name, color, 0, EnumStatus.START));
    }

    public void freePlayer(String pos){
        int ID = Integer.parseInt(pos);
        for ( Player p : GameDB.players) {

            if (p.getStatus() == EnumStatus.TRAPPED && p.getPosition() == ID){
                p.setStatus(EnumStatus.FREE);
            }
        }
    }

}
