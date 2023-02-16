package com.oefening.hallo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HalloController {

    @GetMapping("/halloapp")
    public String halloWereld() {
        return "Hallo, Wereld!";
    }

    @GetMapping("/welkom")
    public String welkomWereld() {
        return "Welkom op deze mooie webserver";
    }

    @GetMapping("/getallen")
    public Integer getallen() {
        return 23;
    }

    @GetMapping("/autos")
    public List<String> autos() {
        List<String> autootjes = new ArrayList<>();
        autootjes.add("BMW");
        autootjes.add("Audi");

        return autootjes;
    }

}
