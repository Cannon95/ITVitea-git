package nl.cannontm.webserver.controller;

import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.services.CallAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {

    @Autowired
    CallAPIService callAPIService;

    @GetMapping
    @RequestMapping("/clan")
    public Clan getClan() {
       return callAPIService.getClan("#28UC9CQ9V");
    }


    @GetMapping
    @RequestMapping("/player")
    public Player getPlayer() {
        return callAPIService.getPlayer("#Q0UVP29JR");
    }


}
