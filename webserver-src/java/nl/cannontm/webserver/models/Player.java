package nl.cannontm.webserver.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String tag;

    private String name;

    private Integer townHallLevel;

    private Long date_check;

    private String ownedBy;

    private String clanTag;

    @ManyToOne
    @JsonBackReference
    private Clan clan;


    @OneToOne(mappedBy = "player")
    @PrimaryKeyJoinColumn
    private Heroes heroes;

    @OneToOne(mappedBy = "player")
    @PrimaryKeyJoinColumn
    private Troops troops;

    @OneToOne(mappedBy = "player")
    @PrimaryKeyJoinColumn
    private DarkTroops darktroops;

    @OneToOne(mappedBy = "player")
    @PrimaryKeyJoinColumn
    private Sieges sieges;

    @OneToOne(mappedBy = "player")
    @PrimaryKeyJoinColumn
    private Spells spells;

    @OneToOne(mappedBy = "player")
    @PrimaryKeyJoinColumn
    private Pets pets;

    public Player(String player_tag, String name){
        this.tag = player_tag;
        this.name = name;
    }

    public Player(String tag, String name, Integer townHallLevel, String ownedBy, Clan clan, String clanTag) {
        this.tag = tag;
        this.name = name;
        this.townHallLevel = townHallLevel;
        this.ownedBy = ownedBy;
        this.clan = clan;
        this.clanTag = clanTag;
    }
}
