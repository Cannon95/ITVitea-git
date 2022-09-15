package com.cannon13695.Eindopdracht1.Entity;

import com.cannon13695.Eindopdracht1.util.Vector;

public abstract class Entity implements Ilivable{

    /** de positie van de entity */
    private Vector position;

    public Entity(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setPosition(x,y,z){
        this.setPosition(new Vector(x,y,z));
    }
}
