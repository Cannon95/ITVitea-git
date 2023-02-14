package nl.cannontm.webserver.controller;

import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cannon")
public class CannonController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    @RequestMapping("/all")
    public List<Player> getAllCannons(){
        return playerService.getAllCannonPlayers();
    }

}
