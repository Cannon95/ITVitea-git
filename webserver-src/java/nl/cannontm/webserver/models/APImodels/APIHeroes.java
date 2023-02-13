package nl.cannontm.webserver.models.APImodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIHeroes {

    private String name;
    private Integer level;
    private Integer maxLevel;
    private String village;


}
