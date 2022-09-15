/**
 * @Author Mark van de Vliert
 * @Since 12-09-2022
 *
 */

package com.cannon13695.Eindopdracht1.Entity;

import com.cannon13695.Eindopdracht1.util.Vector;

public class EntityHuman extends Entity{

    EnumBeroep beroep;
    static int totalHumans = 0;

    public EntityHuman(Vector position, EnumBeroep beroep) {
        super(position);
        this.beroep = beroep;
        this.totalHumans++;
    }

    @Override
    public boolean isDead() {
        return false;
    }





}
