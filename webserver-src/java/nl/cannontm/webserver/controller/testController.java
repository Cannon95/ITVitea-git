package nl.cannontm.webserver.controller;

import nl.cannontm.webserver.config.BotConfig;
import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.services.CallAPIService;
import nl.cannontm.webserver.services.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class testController {

    @Autowired
    CallAPIService callAPIService;

    @Autowired
    ClanService clanService;


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

    @PostMapping
    @RequestMapping("/clan/new/{tag}")
    public Clan newClan(@PathVariable(value = "tag") String tag) {

        Clan clan = callAPIService.getClan("#" + tag);
        return clanService.newClan(clan);
    }

    @PostMapping
    @RequestMapping("/message/{tag}")
    public String sendMessage(@PathVariable(value = "tag") String tag) {

        BotConfig.log(tag);

        return "done";
    }

}
