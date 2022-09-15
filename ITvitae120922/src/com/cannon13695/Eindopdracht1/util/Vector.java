package com.cannon13695.Eindopdracht1.util;

public class Vector {

    private double x,y,z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z; //y waarde
    }

    public void setZ(double z) {
        this.z = z; //z waarde
    }

    /**
     *  berekend de afstand via de stelling van pithagoras
     */
    public double getDistance(){
        return Math.sqrt(x*x + y*y + z*z);
    }

}
