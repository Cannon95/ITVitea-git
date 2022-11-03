package com.markvdvliert.ganzenbord.controller;

import com.markvdvliert.ganzenbord.database.GameDB;
import com.markvdvliert.ganzenbord.model.types.AddPlayerType;
import com.markvdvliert.ganzenbord.model.types.SendAddPlayerType;
import com.markvdvliert.ganzenbord.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/ganzenbord/addPlayer")
    public SendAddPlayerType addPlayer(@RequestBody AddPlayerType t){
        new PlayerService().addPlayer(t.player(), t.color());
        System.out.println("player: " + t.player() + " , color: " + t.color());
        return new SendAddPlayerType(GameDB.players.size()-1 + "", t.player());
    }



}
