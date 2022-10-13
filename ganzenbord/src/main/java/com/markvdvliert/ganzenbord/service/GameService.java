package com.markvdvliert.ganzenbord.service;

import com.markvdvliert.ganzenbord.database.GameDB;
import com.markvdvliert.ganzenbord.model.*;

import java.util.Random;

public class GameService {

    public String startGame(){
        GameDB.isStarted = true;
        String[] message = new String[GameDB.players.size()];
        if(GameDB.players.size() == 0){
            return "er zijn nog geen spelers aangemaakt, maak minstens 1 speler aan";
        }
        for (int i = 0; i < message.length; i++) {
            message[i] = GameDB.players.get(i).getColor();
        }
        return "start";
    }


    public static String[] gooien(){
        GameDB.thr1 = new Random().nextInt(6) + 1;
        GameDB.thr2 = new Random().nextInt(6) + 1;
        Player player = GameDB.players.get(GameDB.PlayerTurn);
        int pos = player.getPosition();
        if(player.getStatus() == EnumStatus.START){
            player.setStatus(EnumStatus.FREE);
            if(GameDB.thr1 == 5 && GameDB.thr2 == 4 || GameDB.thr1 == 4 && GameDB.thr2 == 5){
                int newPos = 53;
                if(fieldInUse(newPos)){
                    newPos = 0;
                }
                player.setPosition(newPos);
                return new String[]{GameDB.PlayerTurn + "",player.getPlayerName(), newPos + "",GameDB.thr1 + "",GameDB.thr2 + "", 0 + "", nextPlayer() + "", not0(),player.getColor()};
            }
            else if(GameDB.thr1 == 3 && GameDB.thr2 == 6 || GameDB.thr1 == 6 && GameDB.thr2 == 3){
                int newPos = 26;
                if(fieldInUse(newPos)){
                    newPos = 0;
                }
                player.setPosition(newPos);
                return new String[]{GameDB.PlayerTurn + "",player.getPlayerName(), newPos + "",GameDB.thr1 + "",GameDB.thr2 + "", 0 + "", nextPlayer() + "", not0(),player.getColor()};
            }
        }
        else{
            if(player.getPosition() == 0 && GameDB.thr1 + GameDB.thr2 == 9){
                player.setStatus(EnumStatus.FINISHED);
            }
            return field(player,pos, GameDB.thr1,GameDB.thr2);

        }
        return new String[0];
    }

    public static String[] field(Player player, int pos, int thro1, int thro2){
        System.out.println("Player: " + player.getPlayerName() + " , pos: " + pos + " , thro1: " + thro1 + " , thro2: " + thro2);
        int finalPos = pos + thro1 + thro2;
        if(finalPos > 63){
            int math1 = finalPos - 63;
            finalPos = 63 - math1;
            System.out.println("FinalPos: " + finalPos);
        }
        if(GameDB.fields[finalPos] instanceof GDouble){
            return field(player, pos , thro1*2, thro2*2);
        }
        else{

            GameDB.fields[finalPos].execute(player, thro1 + thro2);
            int newPos = finalPos;
            if(fieldInUse(newPos)){
                newPos = pos;
            }
            player.setPosition(newPos);
            return new String[]{GameDB.PlayerTurn + "",player.getPlayerName(), newPos + "", thro1 + "", thro2 + "", pos + "", nextPlayer() + "", not0(), player.getColor()};
        }


    }
    public static int nextPlayer(){

        do {
            if(GameDB.PlayerTurn + 1 == GameDB.players.size()){
                GameDB.PlayerTurn = 0;
            }
            else{
                GameDB.PlayerTurn++;
            }
        }while(GameDB.players.get(GameDB.PlayerTurn).getStatus() != EnumStatus.FREE && GameDB.players.get(GameDB.PlayerTurn).getStatus() != EnumStatus.START);

        return GameDB.PlayerTurn;
    }

    public static String not0(){
        for (int i = 0; i < GameDB.players.size(); i++) {
            if(GameDB.players.get(i).getPosition() == 0){
                return GameDB.players.get(i).getColor();
            }
        }
        return "true";
    }
    public static boolean fieldInUse(int pos){
        for (int i = 0; i < GameDB.players.size(); i++) {
            if(GameDB.players.get(i).getPosition() == pos){
                return true;
            }
        }
        return false;
    }

}
