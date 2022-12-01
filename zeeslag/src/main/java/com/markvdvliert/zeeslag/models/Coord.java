package com.markvdvliert.zeeslag.models;

public record Coord(int x, int y) {


    public Coord addX(int dx){
        return new Coord(x + dx, y);
    }
    public Coord addY(int dy){
        return new Coord(x, y + dy);
    }

}
