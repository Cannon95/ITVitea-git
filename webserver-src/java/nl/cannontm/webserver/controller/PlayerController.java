package nl.cannontm.webserver.controller;


import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/clans")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    @RequestMapping("/{tag}")
    public Iterable<Player> getClan(@PathVariable(value = "tag") String tag){
        return playerService.getAllPlayersFromClan(tag);
    }



}
