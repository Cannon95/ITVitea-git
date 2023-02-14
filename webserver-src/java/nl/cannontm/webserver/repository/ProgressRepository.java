package nl.cannontm.webserver.repository;

import nl.cannontm.webserver.models.Progress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProgressRepository extends CrudRepository<Progress, Long> {

    Progress findByTag(String tag);

}
