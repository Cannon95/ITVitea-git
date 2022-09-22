package com.markvdvliert.Weekopdrachten.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/phones")
public class BaseController {

    @GetMapping
    public String blabla(@RequestParam(value = "test") String test){
        if(test.equals("hoi"))return "doei";
        else if(test.equals("doei"))return "<strong>STERF!!</strong>";
        else return "code";
    }

}
