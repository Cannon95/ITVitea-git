package nl.cannontm.webserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private String tag;
    private String name;
    private Integer members;

    @OneToMany(mappedBy = "clan")
    private Set<Player> MemberList;





}
