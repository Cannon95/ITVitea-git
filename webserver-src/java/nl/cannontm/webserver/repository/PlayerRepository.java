package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByTag(String tag);
    Iterable<Player> findByClanTag(String clan_tag, Sort sort);


}
