package nl.cannontm.webserver.models;


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

    @ManyToOne
    @JoinColumn(name = "clantag", nullable = false)
    private Clan clan;

    @OneToOne(mappedBy = "player")
    private Heroes heroes;

    @OneToOne(mappedBy = "player")
    private Troops troops;

    @OneToOne(mappedBy = "player")
    private DarkTroops darkTroops;

    @OneToOne(mappedBy = "player")
    private Sieges sieges;

    @OneToOne(mappedBy = "player")
    private Spells spells;

    @OneToOne(mappedBy = "player")
    private Pets pets;

    public Player(String player_tag, String name){
        this.tag = player_tag;
        this.name = name;
    }


}
