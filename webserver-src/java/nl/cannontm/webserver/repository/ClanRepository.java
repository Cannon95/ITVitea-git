package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.Clan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface ClanRepository extends CrudRepository<Clan, Long> {



}
