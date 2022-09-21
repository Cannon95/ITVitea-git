package com.markvdviert.main;

import com.markvdviert.main.gui.Plot;
import com.markvdviert.main.util.LogicalArray;

public class Main {
    public static void main(String[] args) {
        double x[] = new LogicalArray("1:10:1").get();
        double y[] = {100,5,3,8,9,6,0,7,-2,4};
        new Plot("test", x,y);

    }
}