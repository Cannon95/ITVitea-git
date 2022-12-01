package com.markvdvliert.zeeslag.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/zeeslag")
public class InitController {

    @GetMapping
    public String initRequest(){
        return "ui.html";
    }

}
