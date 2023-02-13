package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepository extends CrudRepository<Player, Long> {




}
