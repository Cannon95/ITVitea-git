package nl.markvliert.feb9.repository;

import nl.markvliert.feb9.model.KatModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface KatRepository extends CrudRepository<KatModel, Long> {

    public Mono<KatModel> save(KatModel kat);

    @Query("SELECT * FROM kat")
    public Flux<KatModel> findAllKatten();

}
