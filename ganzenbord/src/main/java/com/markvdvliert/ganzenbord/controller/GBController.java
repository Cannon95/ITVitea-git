package com.markvdvliert.ganzenbord.controller;

import com.markvdvliert.ganzenbord.model.SendForm;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(path = "/ganzenbord")
public class GBController {

    @GetMapping
    public String blabla(@RequestParam(value = "test") String test){

        return "main.html";
    }
    @PostMapping
    @ResponseBody
    public SendForm blabla3(@RequestBody SendForm sf){

        return new SendForm("niks", new String[]{"doen"});
    }


}
