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
public class Spells extends Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "id")
    private Player player;
    private Integer lightning,heal,rage,jump,freeze,clone,invisible,recall,poison,earthquake,haste,skeleton,bat;

    public int total(){
        return valuate(this.lightning) +
                valuate(this.heal) +
                valuate(this.rage) +
                valuate(this.jump) +
                valuate(this.freeze) +
                valuate(this.clone) +
                valuate(this.invisible) +
                valuate(this.recall) +
                valuate(this.poison) +
                valuate(this.earthquake) +
                valuate(this.haste) +
                valuate(this.skeleton) +
                valuate(this.bat);
    }

    private int valuate(Integer stat){
        return stat == null ? 0 : stat;
    }

}
