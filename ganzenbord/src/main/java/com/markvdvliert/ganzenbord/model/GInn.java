package com.markvdvliert.ganzenbord.model;

public class GInn extends GField{


    @Override
    public int execute(Player player, int thr){
        player.setStatus(EnumStatus.SKIP);
        return player.getPosition() + thr;
    }
}
