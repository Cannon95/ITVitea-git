package nl.cannontm.webserver.API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/coc")
public class COCinitEndPoint {

    @GetMapping
    public String initRequest(){
        System.out.println("test123");
        return "coc.html";
    }

}
