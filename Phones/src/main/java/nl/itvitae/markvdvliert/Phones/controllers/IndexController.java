package nl.itvitae.markvdvliert.Phones.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import nl.itvitae.markvdvliert.Phones.models.TestObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/phones")
public class IndexController {

    @GetMapping
    public String blabla(@RequestParam(value = "test") String test){
        return "main.html";
    }

    @PostMapping
    @ResponseBody
    public TestObject blabla2(@RequestParam("test") TestObject test){
        System.out.println(test.getNaam());
        return test;
    }

}
