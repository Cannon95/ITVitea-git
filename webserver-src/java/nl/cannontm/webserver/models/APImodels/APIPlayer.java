package nl.cannontm.webserver.models.APImodels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class APIPlayer {

    private String tag;

    private String name;

    private Integer townHallLevel;

    private List<APITroops> troops;

    private List<APIHeroes> heroes;

    private List<APISpells> spells;

    private APIClan clan;




}
