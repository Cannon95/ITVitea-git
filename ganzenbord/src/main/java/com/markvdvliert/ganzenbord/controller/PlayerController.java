package com.markvdvliert.ganzenbord.controller;

import com.markvdvliert.ganzenbord.database.GameDB;
import com.markvdvliert.ganzenbord.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/ganzenbord/addPlayer")
    public String[] addPlayer(@RequestBody String player, @RequestBody String color){
        new PlayerService().addPlayer(player, color);
        return new String[]{GameDB.players.size()-1 + "", player};
    }



}
