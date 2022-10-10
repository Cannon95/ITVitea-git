package com.markvdvliert.ganzenbord.model;

public class GField {
    public void execute(Player player, int thr){}

}

class GWell extends GField{
    @Override
    public void execute(Player player, int thr){
        player.setStatus(EnumStatus.TRAPPED);
    }
}
class GJail extends GField{
    @Override
    public void execute(Player player, int thr){
        player.setStatus(EnumStatus.TRAPPED);
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
    public void execute(Player player, int thr){
        player.setPosition(this.pos);
    }

}
class GInn extends GField{


    @Override
    public void execute(Player player, int thr){
        player.setStatus(EnumStatus.SKIP);
    }
}
