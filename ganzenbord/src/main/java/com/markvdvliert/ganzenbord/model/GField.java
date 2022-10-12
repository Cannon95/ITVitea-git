package com.markvdvliert.ganzenbord.model;

public class GField {
    public int execute(Player player, int thr){
        return player.getPosition() + thr;
    }

}

class GWell extends GField{
    @Override
    public int execute(Player player, int thr){

        player.setStatus(EnumStatus.TRAPPED);
        return player.getPosition() + thr;
    }
}
class GJail extends GField{
    @Override
    public int execute(Player player, int thr){
        player.setStatus(EnumStatus.TRAPPED);
        return player.getPosition() + thr;
    }
}
class GDouble extends GField{

}

class GSwift extends GField{
    int pos;
    public GSwift(int pos){
        super();
        this.pos = pos;
    }
    @Override
    public int execute(Player player, int thr){

        return this.pos;
    }

}
class GInn extends GField{


    @Override
    public int execute(Player player, int thr){
        player.setStatus(EnumStatus.SKIP);
        return player.getPosition() + thr;
    }
}
