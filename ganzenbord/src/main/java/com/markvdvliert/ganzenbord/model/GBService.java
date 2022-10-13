package com.markvdvliert.ganzenbord.model;

import com.markvdvliert.ganzenbord.model.GDouble;
import com.markvdvliert.ganzenbord.model.GField;
import com.markvdvliert.ganzenbord.model.Player;
import com.markvdvliert.ganzenbord.model.EnumStatus;

import java.lang.reflect.GenericArrayType;
import java.util.*;
import java.util.function.Consumer;

public class GBService {

    public static List<Player> players = new ArrayList<>();//new ArrayList<>();
    public static int PlayerTurn = 0;
    static int thr1;
    static int thr2;
    public static boolean isStarted = false;


    public static GField[] fields = new GField[64];

    public static void init(){
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


    public static SendForm throwDices(){
        thr1 = new Random().nextInt(6) + 1;
        thr2 = new Random().nextInt(6) + 1;
        Player player = players.get(PlayerTurn);
        int pos = player.getPosition();
        if(player.getStatus() == EnumStatus.START){
            player.setStatus(EnumStatus.FREE);
            if(thr1 == 5 && thr2 == 4 || thr1 == 4 && thr2 == 5){
                int newPos = 53;
                if(fieldInUse(newPos)){
                    newPos = 0;
                }
                player.setPosition(newPos);
                return new SendForm("vlieg", new String[]{PlayerTurn + "",player.getPlayerName(), newPos + "",thr1 + "",thr2 + "", 0 + "", nextPlayer() + "", not0(),player.getColor()});
            }
            else if(thr1 == 3 && thr2 == 6 || thr1 == 6 && thr2 == 3){
                int newPos = 26;
                if(fieldInUse(newPos)){
                    newPos = 0;
                }
                player.setPosition(newPos);
                return new SendForm("vlieg", new String[]{PlayerTurn + "",player.getPlayerName(), newPos + "",thr1 + "",thr2 + "", 0 + "", nextPlayer() + "", not0(),player.getColor()});
            }
        }
        else{
            if(player.getPosition() == 0 && thr1 + thr2 == 9){
                player.setStatus(EnumStatus.FINISHED);
            }
            return field(player,pos, thr1,thr2);

        }
        return new SendForm("err", new String[0]);
    }

    public static SendForm field(Player player, int pos, int thro1, int thro2){
        System.out.println("Player: " + player.getPlayerName() + " , pos: " + pos + " , thro1: " + thro1 + " , thro2: " + thro2);
        int finalPos = pos + thro1 + thro2;
        if(finalPos > 63){
            int math1 = finalPos - 63;
            finalPos = 63 - math1;
            System.out.println("FinalPos: " + finalPos);
        }
        if(fields[finalPos] instanceof GDouble){
            return field(player, pos , thro1*2, thro2*2);
        }
        else{

            fields[finalPos].execute(player, thro1 + thro2);
            int newPos = finalPos;
            if(fieldInUse(newPos)){
                newPos = pos;
            }
            player.setPosition(newPos);
            return new SendForm("gooi", new String[]{PlayerTurn + "",player.getPlayerName(), newPos + "", thro1 + "", thro2 + "", pos + "", nextPlayer() + "", not0(), player.getColor()});
        }


    }
    public static int nextPlayer(){

        do {
            if(PlayerTurn + 1 == GBService.players.size()){
                PlayerTurn = 0;
            }
            else{
                PlayerTurn++;
            }
        }while(players.get(PlayerTurn).getStatus() != EnumStatus.FREE && players.get(PlayerTurn).getStatus() != EnumStatus.START);

        return PlayerTurn;
    }

    public static String not0(){
        for (int i = 0; i < GBService.players.size(); i++) {
            if(GBService.players.get(i).getPosition() == 0){
                return GBService.players.get(i).getColor();
            }
        }
        return "true";
    }
    public static boolean fieldInUse(int pos){
        for (int i = 0; i < GBService.players.size(); i++) {
            if(GBService.players.get(i).getPosition() == pos){
                return true;
            }
        }
        return false;
    }

}
