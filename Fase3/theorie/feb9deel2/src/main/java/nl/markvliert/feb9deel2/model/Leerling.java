package nl.markvliert.feb9deel2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Leerling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naam;
    private Integer klas;
    private String wachtwoord;
    @ManyToOne
    @JoinColumn(name="school_id", nullable=false)
    private School school;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactpersoon_id", referencedColumnName = "id")
    private Contactpersoon contactpersoon;

    public Leerling(String naam, Integer klas, School school) {
        this.naam = naam;
        this.klas = klas;
        this.school = school;
    }
}
