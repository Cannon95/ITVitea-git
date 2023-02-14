package nl.cannontm.webserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tag;
    private Integer monthlyHeroes;
    private Integer monthlyLab;
    private Integer monthlyPets;
    private Long datestamp;


}
