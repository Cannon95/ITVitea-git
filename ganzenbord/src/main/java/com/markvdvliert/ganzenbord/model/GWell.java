package com.markvdvliert.ganzenbord.model;

import com.markvdvliert.ganzenbord.database.GameDB;

public class GWell extends GField{
    @Override
    public int execute(Player player, int pos, int thr){

        player.setStatus(EnumStatus.SKIP);
        for (int i = 0; i < GameDB.players.size(); i++) {
            if(player.getPosition() > GameDB.players.get(i).getPosition()){
                player.setStatus(EnumStatus.TRAPPED);
            }
        }
        return pos;
    }
}
