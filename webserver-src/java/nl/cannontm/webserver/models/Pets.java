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
public class Pets extends Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "id")
    private Player player;
    private Integer lassi,owl,yak,unicorn,frosty,diggy,lizard,phoenix;

    public int total(){
        return valuate(this.lassi) +
                valuate(this.owl) +
                valuate(this.yak) +
                valuate(this.unicorn) +
                valuate(this.frosty) +
                valuate(this.diggy) +
                valuate(this.lizard) +
                valuate(this.phoenix);
    }

    private int valuate(Integer stat){
        return stat == null ? 0 : stat;
    }

}
