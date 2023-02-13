package nl.cannontm.webserver.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tag;
    private String name;

    private Integer shouldTrack; //0 =  Not at all, even the players in that clan will not get tracked. only used by "Other" clan. 1 = clan memberlist will not be tracked, but the members in that clan will be tracked. 2 = memberlist also get checked


    @PrePersist
    public void setPre(){
        if(shouldTrack == null)shouldTrack = 1;
    }

    @OneToMany
    @JsonManagedReference
    private List<Player> memberList;

    public Clan(String tag1, String name, List<Player> memberList) {
        this.tag = tag1;
        this.name = name;
        this.memberList = memberList;
    }


    public void AddMember(Player player){
        memberList.add(player);
    }
    public synchronized void removePlayer(String tag){
        for (int i = 0; i< memberList.size(); i++){
            if(memberList.get(i).getTag().equals(tag)){
                memberList.remove(i);
                return;
            }
        }
    }





}
