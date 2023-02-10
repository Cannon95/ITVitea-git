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
public class Troops {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "player_tag")
        private Player player;
        private Integer barbarian,archer,giant,goblin,wallbreaker,balloon,wizard,healer,dragon,pekka,babydragon,miner,electrodragon,yeti,dragonrider,electrotitan;

}
