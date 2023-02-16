package nl.markvdvliert.vogeltheorie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Vogel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naam;
    private String soort;

}
