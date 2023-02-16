package nl.markvliert.feb9.controller;

import nl.markvliert.feb9.model.KatModel;
import nl.markvliert.feb9.service.KatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@CrossOrigin
@RequestMapping("/api/kat")
public class KatController {

    @Autowired
    KatService katService;

    @PostMapping("/new")
    public Mono<KatModel> newKat(@RequestBody KatModel kat){
        return katService.newKat(kat);
    }

    @GetMapping("/all")
    public Flux<KatModel> getAllKatten(){
        return katService.getAllKatten();
    }


}
