package nl.markvdvliert.vogeltheorie.repository;

import nl.markvdvliert.vogeltheorie.model.Vogel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface VogelRepository extends CrudRepository<Vogel, Long> {

    Iterable<Vogel> findByNaam(String naam);
    Iterable<Vogel> findBySoort(String soort);
}
