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
public class Sieges extends Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "id")
    private Player player;
    private Integer wallwrecker,battleblimp,stoneslammer,siegebarracks,loglauncher,flameflinger,battledrill;

    public int total(){
        return valuate(this.wallwrecker) +
                valuate(this.battleblimp) +
                valuate(this.stoneslammer) +
                valuate(this.siegebarracks) +
                valuate(this.loglauncher) +
                valuate(this.flameflinger) +
                valuate(this.battledrill);
    }

    private int valuate(Integer stat){
        return stat == null ? 0 : stat;
    }


}
