package nl.markvliert.feb9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class KatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naam;
    private Integer leeftijd;

    public KatModel(String naam, Integer leeftijd){
        this.naam = naam;
        this.leeftijd = leeftijd;
    }


}
