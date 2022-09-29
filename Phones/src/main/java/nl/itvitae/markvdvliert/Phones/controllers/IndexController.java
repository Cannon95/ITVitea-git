package nl.itvitae.markvdvliert.Phones.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import nl.itvitae.markvdvliert.Phones.models.TestObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/phones")
public class IndexController {

    @GetMapping
    public String blabla(@RequestParam(value = "test") String test){
        return "main.html";
    }

    @PostMapping(consumes = "application/json")
    @ResponseBody
    public String blabla3(@RequestBody String test){
        System.out.println("endpoint b");
        System.out.println(test);
        return test;
    }

}
