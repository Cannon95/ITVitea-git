package nl.markvdvliert.vogeltheorie.controller;

import nl.markvdvliert.vogeltheorie.model.Vogel;
import nl.markvdvliert.vogeltheorie.service.VogelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/vogel")
public class VogelController {

    @Autowired
    VogelService vogelService;

    @PostMapping("/new")
    public Vogel newVogel(@RequestBody Vogel vogel){
        return vogelService.newVogel(vogel);
    }

    @GetMapping("/naam/{naam}")
    public Iterable<Vogel> getVogelByNaam(@PathVariable(value = "naam") String naam){
        return vogelService.getVogelByNaam(naam);
    }

    @GetMapping("/soort/{soort}")
    public Iterable<Vogel> getVogelBySoort(@PathVariable(value = "soort") String soort){
        return vogelService.getVogelBySoort(soort);
    }

    @GetMapping("/all")
    public Iterable<Vogel> getAllVogels(){
        return vogelService.getAllVogels();
    }


}
