package com.markvdviert.main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LogicalArray {

    List<Double> list = new ArrayList<>();;
    String command;
    public LogicalArray(int xArrLength,String command) {
        this.command = command;
        if(simpleArr(xArrLength)){}
        else System.out.println("Error, not valid!");
    }


    public LogicalArray(double[] x, Function<Double,Double> handler){
        for (int i = 0; i < x.length; i++) {
            list.add(handler.apply(x[i]));
        }
    }

    public double[] get(){
        double[] d = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            d[i] = list.get(i);
        }
        return d;
    }


    public boolean simpleArr(int xArrLength){
        if(command.split(":").length == 2){
            String[] splitter = command.split(":");


            if(splitter[0].matches("[0-9]+") &&  splitter[1].matches("[0-9]+")){
                try {
                    double start = Double.parseDouble(splitter[0]);
                    double step = Double.parseDouble(splitter[1]);
                    for (double i = start; i <= xArrLength; i += step) {
                        list.add(i);
                    }
                    return true;
                }catch(NumberFormatException e){
                    System.out.println("Error, Incorrect Array! Please use the syntax start:increment");
                    return false;
                }

            }

        }
        return false;
    }




}
