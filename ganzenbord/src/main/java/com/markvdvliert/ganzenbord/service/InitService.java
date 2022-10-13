package com.markvdvliert.ganzenbord.service;

import com.markvdvliert.ganzenbord.database.GameDB;
import com.markvdvliert.ganzenbord.model.*;

import java.util.Arrays;

public class InitService {



    public void init(){
        Arrays.fill(GameDB.fields, new GField());
        GameDB.fields[5] = new GDouble();
        GameDB.fields[6] = new GSwift(12);
        GameDB.fields[9] = new GDouble();
        GameDB.fields[14] = new GDouble();
        GameDB.fields[18] = new GDouble();
        GameDB.fields[19] = new GInn();
        GameDB.fields[23] = new GDouble();
        GameDB.fields[27] = new GDouble();
        GameDB.fields[31] = new GWell();
        GameDB.fields[32] = new GDouble();
        GameDB.fields[36] = new GDouble();
        GameDB.fields[41] = new GDouble();
        GameDB.fields[42] = new GSwift(37);
        GameDB.fields[45] = new GDouble();
        GameDB.fields[50] = new GDouble();
        GameDB.fields[52] = new GJail();
        GameDB.fields[54] = new GDouble();
        GameDB.fields[58] = new GSwift(0);
        GameDB.fields[59] = new GDouble();


    }


}
