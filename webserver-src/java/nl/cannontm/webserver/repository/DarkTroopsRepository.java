package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.DarkTroops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface DarkTroopsRepository extends CrudRepository<DarkTroops, Long> {


}
