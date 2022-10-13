package com.markvdvliert.ganzenbord.controller;


import com.markvdvliert.ganzenbord.service.InitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/ganzenbord")
public class InitController {

    @GetMapping
    public String iniRequest(){
        new InitService().init();
        return "main.html";
    }

}
