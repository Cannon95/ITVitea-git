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
public class Heroes extends Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "id")
    private Player player;
    private Integer king,queen,warden,champion;


    public int total(){
        return valuate(this.king) +
                valuate(this.queen) +
                valuate(this.warden) +
                valuate(this.champion);
    }

    private int valuate(Integer stat){
        return stat == null ? 0 : stat;
    }

}
