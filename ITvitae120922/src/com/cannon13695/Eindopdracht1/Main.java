package com.cannon13695.Eindopdracht1;

import com.cannon13695.Eindopdracht1.Entity.EntityHuman;
import com.cannon13695.Eindopdracht1.Entity.EnumBeroep;
import com.cannon13695.Eindopdracht1.util.Vector;

public class Main {

    public static void main(String[] args){
        EntityHuman human = new EntityHuman(new Vector(0,0,0), EnumBeroep.VISSER);
    }
}
