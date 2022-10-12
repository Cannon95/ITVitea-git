package com.markvdvliert.ganzenbord.controller;

import com.markvdvliert.ganzenbord.model.EnumStatus;
import com.markvdvliert.ganzenbord.model.GBService;
import com.markvdvliert.ganzenbord.model.Player;
import com.markvdvliert.ganzenbord.model.SendForm;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(path = "/ganzenbord")
public class GBController {

    @GetMapping
    public String blabla(@RequestParam(value = "test") String test){
        GBService.init();
        return "main.html";
    }
    @PostMapping
    @ResponseBody
    public SendForm blabla3(@RequestBody SendForm sf){
        if(sf.action().equals("addPlayer")){
            System.out.println("input1: " + sf.message()[0] + " , 2: " + sf.message()[1]);
            GBService.players.add(new Player(sf.message()[0], sf.message()[1], 0, EnumStatus.START));

            return new SendForm("addPlayer", new String[]{GBService.players.size()-1 + "", sf.message()[0]});
        }
        else if(sf.action().equals("start")){
            GBService.isStarted = true;
            String[] message = new String[GBService.players.size()];
            for (int i = 0; i < GBService.players.size(); i++) {
                message[i] = GBService.players.get(i).getColor();
            }
            return new SendForm("start", new String[]{});
        }
        else if(sf.action().equals("gooi")){
            GBService.throwDices();
        }
        else if(sf.action().equals("check")){
            int ID = Integer.parseInt(sf.message()[1]);
            for ( Player p :GBService.players) {

                if (p.getStatus() == EnumStatus.TRAPPED && p.getPosition() == ID){
                    p.setStatus(EnumStatus.FREE);
                }
            }
        }
        System.out.println("" + sf.action() + "input1: " + sf.message()[0] + " , 2: " + sf.message()[1]);
        return new SendForm("niks", new String[]{"doen"});
    }


}
