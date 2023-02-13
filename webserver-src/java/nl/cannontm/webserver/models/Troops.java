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
public class Troops extends Stat {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @OneToOne
        @MapsId
        @JoinColumn(name = "id")
        private Player player;
        private Integer barbarian,archer,giant,goblin,wallbreaker,balloon,wizard,healer,dragon,pekka,babydragon,miner,electrodragon,yeti,dragonrider,electrotitan;

        public int total(){
               return valuate(this.barbarian) +
                valuate(this.archer) +
                valuate(this.giant) +
                valuate(this.goblin) +
                valuate(this.wallbreaker) +
                valuate(this.balloon) +
                valuate(this.wizard) +
                valuate(this.healer) +
                valuate(this.dragon) +
                valuate(this.pekka) +
                valuate(this.miner) +
                valuate(this.electrodragon) +
                valuate(this.yeti) +
                valuate(this.dragonrider) +
                valuate(this.electrotitan);
        }

        private int valuate(Integer stat){
                return stat == null ? 0 : stat;
        }


}
