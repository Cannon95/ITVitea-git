package nl.itvitae.markvdvliert.Phones.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import nl.itvitae.markvdvliert.Phones.models.SendForm;
import nl.itvitae.markvdvliert.Phones.models.TestObject;
import nl.itvitae.markvdvliert.Phones.services.PhoneService;
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

    @PostMapping
    @ResponseBody
    public SendForm blabla3(@RequestBody SendForm sf){
        PhoneService service = new PhoneService();
        for (String s: sf.message()) {
            System.out.println("action: " + sf.action() + " , message: " + s);
        }

        if(sf.action().equals("getPhone")){
            if(sf.message()[0].equals("back")){
                return service.init();
            }
            return service.getPhone(sf.message()[0]);
        }
        else if(sf.action().equals("init")){
            return service.init();
        }
        else if(sf.action().equals("search")){
            return service.search(sf.message()[0]);
        }
        String[] message = {"undefined"};
        return new SendForm("postmapping", message);
    }

}
