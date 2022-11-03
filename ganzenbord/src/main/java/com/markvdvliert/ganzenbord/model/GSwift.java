package com.markvdvliert.ganzenbord.model;


    public class GSwift extends GField{
        int pos;
        public GSwift(int pos){
            super();
            this.pos = pos;
        }
        @Override
        public int execute(Player player, int pos, int thr){

            return this.pos;
        }

    }

