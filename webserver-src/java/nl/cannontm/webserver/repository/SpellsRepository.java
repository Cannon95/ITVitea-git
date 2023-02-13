package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.Spells;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface SpellsRepository extends CrudRepository<Spells, Long> {
}
