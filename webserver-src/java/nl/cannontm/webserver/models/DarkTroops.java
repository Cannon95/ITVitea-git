package nl.cannontm.webserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class DarkTroops extends Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "id")
    private Player player;
    private Integer minion,hogrider,valkyrie,golem,witch,lavahound,bowler,icegolem,headhunter;

    public int total(){
        return valuate(this.minion) +
                valuate(this.hogrider) +
                valuate(this.valkyrie) +
                valuate(this.golem) +
                valuate(this.witch) +
                valuate(this.lavahound) +
                valuate(this.bowler) +
                valuate(this.icegolem) +
                valuate(this.headhunter);
    }

    private int valuate(Integer stat){
        return stat == null ? 0 : stat;
    }
}
