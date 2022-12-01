package com.markvdvliert.zeeslag.services;

import com.markvdvliert.zeeslag.models.Coord;

public class ServiceGame {

    public void Shoot(int player, int x, int y){

        int otherPlayer = player == 1 ? 2 : 1;
        boolean heeftIetsGeraakt = false;
        if(player == 1){
            if(ZeeslagDB.VELD_2[x][y] == enumStatus.LEEG) {
                for (int i = 0; i < ZeeslagDB.SCHEPEN[otherPlayer].length; i++) {
                    for (Coord coord : ZeeslagDB.SCHEPEN[otherPlayer][i].getLocs()) {
                        if (new Coord(x, y).equals(coord)) {
                            ZeeslagDB.VELD_2[x][y] = enumStatus.RAAK;
                            heeftIetsGeraakt = true;
                        }
                    }
                }
            }
        }

    }

}
