package nl.markvliert.feb9deel2.repository;

import nl.markvliert.feb9deel2.model.Leerling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeerlingRepository extends CrudRepository<Leerling, Long> {

}
