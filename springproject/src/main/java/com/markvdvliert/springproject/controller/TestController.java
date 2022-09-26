package com.markvdvliert.springproject.controller;

import com.markvdvliert.springproject.model.Boek;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping
    public String blabla(@RequestParam(value = "test") String test){
        if(test.equals("hoi"))return "doei";
        else if(test.equals("doei"))return "<strong>STERF!!</strong>";
        else return "code";
    }

    @PostMapping("/nieuw")
    public void testMapping(@RequestBody Boek boek) {
        System.out.println(boek.naam);
    }


}

