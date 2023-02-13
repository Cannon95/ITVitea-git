package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.Notitions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface NotitionRepository extends CrudRepository<Notitions, Long> {

}
