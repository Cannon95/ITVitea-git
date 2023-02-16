package nl.markvliert.feb9.service;

import jakarta.transaction.Transactional;
import nl.markvliert.feb9.model.KatModel;
import nl.markvliert.feb9.repository.KatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class KatService {

    @Autowired
    KatRepository katRepository;

    public Mono<KatModel> newKat(KatModel kat) {
        return katRepository.save(kat);
    }

    public Flux<KatModel> getAllKatten() {
        return katRepository.findAllKatten();
    }
}
