package com.markvdvliert.zeeslag.services;

import com.markvdvliert.zeeslag.models.Coord;
import com.markvdvliert.zeeslag.models.EnumOrientation;
import com.markvdvliert.zeeslag.models.Forms.MoveShipForm;
import com.markvdvliert.zeeslag.models.Schip;

/** This Service Class is used to move the Ships into the desired place before the start of the game */
public class ServiceMoveShip {

    public MoveShipForm MoveShip(String key, int shipID, int player){
        Schip ship;
        Schip movedShip = null;

            ship = ZeeslagDB.SCHEPEN[player][shipID];

       if(key.equals("Control")){
           movedShip = new Schip(ship.getType(),ship.getCoord(), EnumOrientation.flip(ship.getOrientation()));
       }
       else if(key.equals("ArrowLeft")){

           movedShip = new Schip(ship.getType(),ship.getCoord().addX(-1), ship.getOrientation());
       }
       else if(key.equals("ArrowRight")){
           movedShip = new Schip(ship.getType(),ship.getCoord().addX(1), ship.getOrientation());
       }
       else if(key.equals("ArrowUp")){
           movedShip = new Schip(ship.getType(),ship.getCoord().addY(-1), ship.getOrientation());
       }
       else if(key.equals("ArrowDown")){
           movedShip = new Schip(ship.getType(),ship.getCoord().addY(1), ship.getOrientation());
       }
       try {
           if (isLocationEmpty(movedShip.getLocs(), shipID, player)) {
               if(player == 1){
                   ZeeslagDB.SCHEPEN[player][shipID] = movedShip;
               }

               return new MoveShipForm(player, shipID,movedShip.getCoord().x(), movedShip.getCoord().y(), movedShip.getOrientation().name());
           }
       }
       catch(NullPointerException e){
           System.err.println("ERROR: Invalid Key Type: " + key);
       }
       return new MoveShipForm(player, shipID,ship.getCoord().x(), ship.getCoord().y(), ship.getOrientation().name());
    }


    public boolean isLocationEmpty(Coord[] coords, int ship, int player){

        for (Coord coord : coords) {
            for (int i = 0; i < 10; i++) {
                if(player == 1){
                    for (Coord usedCoord : ZeeslagDB.SCHEPEN[player][i].getLocs()) {
                        if(coord.equals(usedCoord) && ship != i && coord.x() > -1 && coord.x() < 10 && coord.y() > -1 && coord.y() < 10){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
