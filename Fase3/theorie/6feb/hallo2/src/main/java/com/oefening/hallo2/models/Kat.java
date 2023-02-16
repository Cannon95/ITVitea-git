package com.oefening.hallo2.models;

import jakarta.persistence.*;


@Entity
@Table(name = "kat")
public class Kat {


    public Kat(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String naam;
    private Integer leeftijd;


    public Kat(String naam, Integer leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
