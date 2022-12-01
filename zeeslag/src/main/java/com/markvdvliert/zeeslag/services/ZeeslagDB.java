package com.markvdvliert.zeeslag.services;

import com.markvdvliert.zeeslag.models.Schip;

public class ZeeslagDB {
    public static enumStatus VELD_1[][] = new enumStatus[10][10];
    public static enumStatus VELD_2[][] = new enumStatus[10][10];

    public static Schip[][] SCHEPEN = new Schip[2][10];


}


enum enumStatus{
    LEEG,
    BESCHOTEN,
    RAAK

}
