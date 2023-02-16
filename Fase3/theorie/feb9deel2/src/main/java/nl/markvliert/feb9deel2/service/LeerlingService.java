package nl.markvliert.feb9deel2.service;

import jakarta.transaction.Transactional;
import nl.markvliert.feb9deel2.model.Contactpersoon;
import nl.markvliert.feb9deel2.model.Leerling;
import nl.markvliert.feb9deel2.repository.LeerlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class LeerlingService {

    @Autowired
    private LeerlingRepository leerlingRepository;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ContactpersoonService contactpersoonService;

    public Leerling newLeerling(Leerling leerling) {
        return leerlingRepository.save(leerling);
    }

    public Optional<Leerling> getLeerling(Long id) {
        return leerlingRepository.findById(id);
    }

    public Iterable<Leerling> getAllLeerlingen() {
        return leerlingRepository.findAll();
    }

    public Leerling updateLeerling(Long id, Leerling nieuweLeerling){

        if(nieuweLeerling == null || nieuweLeerling.getId() == null || !leerlingRepository.existsById(id)){
            return nieuweLeerling;
        }

        Leerling leerling = leerlingRepository.findById(id).get();

        if(nieuweLeerling.getNaam() != null){
            leerling.setNaam(nieuweLeerling.getNaam());
        }
        if(nieuweLeerling.getKlas() != null)
        {
            leerling.setKlas(nieuweLeerling.getKlas());
        }
        if(nieuweLeerling.getSchool() != null){
            leerling.setSchool(nieuweLeerling.getSchool());
        }

        return leerlingRepository.save(leerling);
    }

    public void deleteLeerling(Long id) {
       leerlingRepository.deleteById(id);
    }

    public void deleteAllLeerlingen() {
        leerlingRepository.deleteAll();
    }


    public Leerling addContactpersoonToLeerling(Long id, Contactpersoon contactpersoon){
        if(!leerlingRepository.existsById(id))return null;

        Leerling leerling = leerlingRepository.findById(id).get();

        Contactpersoon tempcp = contactpersoonService.newContactpersoon(leerling, contactpersoon);
        leerling.setContactpersoon(tempcp);
        return leerlingRepository.save(leerling);
    }
}
