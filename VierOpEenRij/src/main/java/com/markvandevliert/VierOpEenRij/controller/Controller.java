package com.markvandevliert.VierOpEenRij.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class Controller {
    @GetMapping
    public String blabla(@RequestParam(value = "task") String test){
        String htmlAdd = "";
        if(test.equals("init")){
            for (char c = 'a'; c < 'h'; c++) {
                for (int j = 1; j < 7; j++) {
                    htmlAdd += "<div class=\""+ c + "" + j + "\"></div>";
                }
            }

        }
        else if(test.equals("doei"))return "<strong>STERF!!</strong>";
        else return "code";
    }

    @PostMapping("/nieuw")
    public void testMapping(@RequestBody Boek boek) {
        System.out.println(boek.naam);
    }
}
