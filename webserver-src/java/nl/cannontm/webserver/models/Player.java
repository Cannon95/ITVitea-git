package nl.cannontm.webserver.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    private String tag;

    private String name;

    private Integer townHallLevel;

    @ManyToOne
    @JsonBackReference
    private Clan clan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "heroes_id")
    private Heroes heroes;

    @OneToOne(cascade = CascadeType.ALL)
    private Troops troops;

    @OneToOne(cascade = CascadeType.ALL)
    private DarkTroops darkTroops;

    @OneToOne(cascade = CascadeType.ALL)
    private Sieges sieges;

    @OneToOne(cascade = CascadeType.ALL)
    private Spells spells;

    @OneToOne(cascade = CascadeType.ALL)
    private Pets pets;

    public Player(String player_tag, String name){
        this.tag = player_tag;
        this.name = name;
    }


}
