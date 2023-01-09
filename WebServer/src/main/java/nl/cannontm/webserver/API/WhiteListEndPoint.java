package nl.cannontm.webserver.API;

import nl.cannontm.webserver.models.WhiteListRow;
import nl.cannontm.webserver.services.WhitelistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WhiteListEndPoint {

    @PostMapping
    @ResponseBody
    @RequestMapping(path = "/coc/submitWhite")
    public WhiteListRow whitelistrow(@RequestBody WhiteListRow r){

        System.out.println(r.playertag());
        new WhitelistService().whitelist(r);
        return r;
    }
}
