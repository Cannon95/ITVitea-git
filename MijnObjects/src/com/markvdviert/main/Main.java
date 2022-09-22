package com.markvdviert.main;

import com.markvdviert.main.gui.Plot;
import com.markvdviert.main.util.LogicalArray;

public class Main {
    public static void main(String[] args) {
        double x[] = new LogicalArray(1000,"0:1").get();
        double y[] = new LogicalArray(x, d -> Math.sin(d/50)+1).get();
        new Plot("test", x,y);

    }
}