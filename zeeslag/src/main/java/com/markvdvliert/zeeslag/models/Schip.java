package com.markvdvliert.zeeslag.models;

public class Schip {

    EnumType type;
    Coord coord;
    EnumOrientation orientation;

    public Schip(EnumType type, Coord coord, EnumOrientation orientation) {
        this.type = type;
        this.coord = coord;
        this.orientation = orientation;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public EnumOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(EnumOrientation orientation) {
        this.orientation = orientation;
    }
    /**
     * This method will check all the locations that this ship is using and returns it into an Coord array.
     * @return the locations the ship is used
     * */
    public Coord[] getLocs(){
        Coord[] locs = new Coord[this.type.getLength()];
        if (this.getOrientation() == EnumOrientation.HORIZONTAL){
            for (int i = 0; i < locs.length; i++) {
                locs[i] = coord.addX(i);
            }
        }
        else{
            for (int i = 0; i < locs.length; i++) {
                locs[i] = coord.addY(i);
            }
        }
        return locs;
    }
}

enum EnumType{
    VLIEGDEKSCHIP(6),
    SLAGSCHIP(4),
    ONDERZEEER(3),
    PATROUILLESCHIP(2);



    private int length;

    private EnumType(int lengte){
        this.length = lengte;
    }

    public int getLength(){
        return this.length;
    }


}

