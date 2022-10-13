package com.markvdvliert.ganzenbord.database;

import com.markvdvliert.ganzenbord.model.GField;
import com.markvdvliert.ganzenbord.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameDB {
    public static List<Player> players = new ArrayList<>();//new ArrayList<>();
    public static int PlayerTurn = 0;
    public static int thr1;
    public static int thr2;
    public static boolean isStarted = false;
    public static GField[] fields = new GField[64];
}
