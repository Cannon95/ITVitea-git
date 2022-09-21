package com.markvdviert.main.util;

import java.util.ArrayList;
import java.util.List;

public class LogicalArray {

    List<Double> list = new ArrayList<>();;
    String command;
    public LogicalArray(String command) {
        this.command = command;
        if(simpleArr()){}
        else{
            for (int i = 0; i < command.length(); i++) {
                String c = String.valueOf(command.charAt(i));
                 if(c.equals("(") && i > 2){ //sin cos tan
                     String code = command.substring(i-3,i-1);
                     if(code.equals("sin")){
                         
                     }
                }
            }
        }
    }

    public double[] get(){
        double[] d = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            d[i] = list.get(i);
        }
        return d;
    }


    public boolean simpleArr(){
        if(command.split(":").length == 3){
            String[] splitter = command.split(":");


            if(splitter[0].matches("[0-9]+") &&  splitter[1].matches("[0-9]+") && splitter[2].matches("[0-9]+")){
                try {
                    double start = Double.parseDouble(splitter[0]);
                    double end = Double.parseDouble(splitter[1]);
                    double step = Double.parseDouble(splitter[2]);
                    for (double i = start; i <= end; i += step) {
                        list.add(i);
                    }
                    return true;
                }catch(NumberFormatException e){
                    System.out.println("Error, Incorrect Array! Please use the syntax n:n:n");
                    return false;
                }

            }

        }
        return false;
    }



}
