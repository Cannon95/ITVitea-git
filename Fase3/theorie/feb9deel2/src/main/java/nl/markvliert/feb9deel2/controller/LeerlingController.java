package nl.markvliert.feb9deel2.controller;

import nl.markvliert.feb9deel2.model.Leerling;
import nl.markvliert.feb9deel2.service.LeerlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/leerling")
public class LeerlingController {

    @Autowired
    private LeerlingService leerlingService;

    @PostMapping
    @RequestMapping("/new")
    public Leerling newLeering(@RequestBody Leerling leerling){
        return leerlingService.newLeerling(leerling);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Leerling> getLeerling(@PathVariable(value = "id") Long id){
        return leerlingService.getLeerling(id);
    }

    @GetMapping
    @RequestMapping("/all")
    public Iterable<Leerling> getAllLeerlinging(){
        return leerlingService.getAllLeerlingen();
    }


    @PutMapping
    @RequestMapping("/update/{id}")
    public Leerling updateLeerling(@PathVariable(value = "id") Long id, @RequestBody Leerling leerling){
        return leerlingService.updateLeerling(id, leerling);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteLeerling(@PathVariable(value = "id") Long id){
        leerlingService.deleteLeerling(id);
    }

    @DeleteMapping
    @RequestMapping("/delete/all")
    public void deleteAllLeerlingen(){
        leerlingService.deleteAllLeerlingen();
    }

    



}
