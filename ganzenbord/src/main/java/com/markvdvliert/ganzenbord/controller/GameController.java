package com.markvdvliert.ganzenbord.controller;

import com.markvdvliert.ganzenbord.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/ganzenbord/startGame")
    public String startGame(){
        return new GameService().startGame();
    }

    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/ganzenbord/gooien")
    public String[] gooien(){
        return new GameService().gooien();
    }



}
