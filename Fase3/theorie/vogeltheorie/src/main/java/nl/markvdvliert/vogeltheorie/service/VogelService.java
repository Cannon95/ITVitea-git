package nl.markvdvliert.vogeltheorie.service;

import jakarta.transaction.Transactional;
import nl.markvdvliert.vogeltheorie.model.Vogel;
import nl.markvdvliert.vogeltheorie.repository.VogelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VogelService {

    @Autowired
    VogelRepository vogelRepository;

    public Vogel newVogel(Vogel vogel){
        return vogelRepository.save(vogel);
    }

    public Iterable<Vogel> getVogelByNaam(String naam) {
        return vogelRepository.findByNaam(naam);
    }

    public Iterable<Vogel> getVogelBySoort(String soort) {
        return vogelRepository.findBySoort(soort);
    }

    public Iterable<Vogel> getAllVogels() {
        return vogelRepository.findAll();
    }
}
