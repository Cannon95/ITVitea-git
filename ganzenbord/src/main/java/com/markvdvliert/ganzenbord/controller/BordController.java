package com.markvdvliert.ganzenbord.controller;


import com.markvdvliert.ganzenbord.model.types.BevrijdingsCheckType;
import com.markvdvliert.ganzenbord.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BordController {

    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/ganzenbord/check")
    public String bevrijdingsCheck(@RequestBody BevrijdingsCheckType type){
        new PlayerService().freePlayer(type.pos() + "");
        return "";
    }
}
