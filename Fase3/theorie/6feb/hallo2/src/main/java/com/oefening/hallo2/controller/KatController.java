package com.oefening.hallo2.controller;

import com.oefening.hallo2.models.Kat;
import com.oefening.hallo2.service.KatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/kat")
public class KatController {

    @Autowired
    KatService katService;

    @GetMapping("/een")
    public Kat getOneKat(){
       return katService.getOneKat();
    }

    @GetMapping("/{id}")
    public Kat getOneKat(@PathVariable(value = "id") long id){
        return katService.getaKat(id);
    }

    @GetMapping("/all")
    public Iterable<Kat> getAllKatten(){
        return katService.getAllKatten();
    }

    @PostMapping("/new")
    public Kat addKat(@RequestBody Kat kat){
        return katService.addKat(kat);
    }

}
