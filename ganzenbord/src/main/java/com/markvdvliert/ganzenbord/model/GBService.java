package com.markvdvliert.ganzenbord.model;

import com.markvdvliert.ganzenbord.model.GDouble;
import com.markvdvliert.ganzenbord.model.GField;
import com.markvdvliert.ganzenbord.model.Player;
import com.markvdvliert.ganzenbord.model.EnumStatus;

import java.lang.reflect.GenericArrayType;
import java.util.*;
import java.util.function.Consumer;

public class GBService {

    public List<Player> players = List.of(new Player("Mark", "blue", 0, EnumStatus.START));//new ArrayList<>();
    public static int PlayerTurn = 0;
    int thr1;
    int thr2;


    GField[] fields = new GField[64];

    public void init(){
        Arrays.fill(fields, new GField());
        fields[5] = new GDouble();
        fields[6] = new GSwift(12);
        fields[9] = new GDouble();
        fields[14] = new GDouble();
        fields[18] = new GDouble();
        fields[19] = new GInn();
        fields[23] = new GDouble();
        fields[27] = new GDouble();
        fields[31] = new GWell();
        fields[32] = new GDouble();
        fields[36] = new GDouble();
        fields[41] = new GDouble();
        fields[42] = new GSwift(37);
        fields[45] = new GDouble();
        fields[50] = new GDouble();
        fields[52] = new GJail();
        fields[54] = new GDouble();
        fields[58] = new GSwift(0);
        fields[59] = new GDouble();


    }


    public void throwDices(){
        thr1 = new Random().nextInt(6) + 1;
        thr2 = new Random().nextInt(6) + 1;
        Player player = players.get(PlayerTurn);
        int pos = player.getPosition();
        if(player.getStatus() == EnumStatus.START){
            player.setStatus(EnumStatus.FREE);
            if(thr1 == 5 && thr2 == 4 || thr1 == 4 && thr2 == 5){
                player.setPosition(53);
            }
            else if(thr1 == 3 && thr2 == 6 || thr1 == 6 && thr2 == 3){
                player.setPosition(26);
            }
        }
        else{
            field(player,pos, thr1 + thr2);
        }

    }

    public void addPlayer(int color){

    }

    public void field(Player player, int pos, int thr){
        int finalPos = pos + thr;
        if(finalPos > 63){
            finalPos = 63 - (finalPos-63);
        }
        if(fields[finalPos] instanceof GDouble){
            field(player, pos + thr, thr);
        }
        else{
            fields[finalPos].execute(player, thr);
        }


    }

}
