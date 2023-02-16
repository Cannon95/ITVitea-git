package nl.markvliert.feb9deel2.service;

import jakarta.transaction.Transactional;
import nl.markvliert.feb9deel2.model.Contactpersoon;
import nl.markvliert.feb9deel2.model.Leerling;
import nl.markvliert.feb9deel2.repository.ContactpersoonRepository;
import nl.markvliert.feb9deel2.repository.LeerlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContactpersoonService {


    @Autowired
    LeerlingRepository leerlingRepository;
    @Autowired
    ContactpersoonRepository contactpersoonRepository;
    public Contactpersoon newContactpersoon(Leerling leerling, Contactpersoon contactpersoon) {

        if(leerlingRepository.existsById(leerling.getId())){
            return null;
        }
        contactpersoon.setLeerling(leerling);
        return contactpersoonRepository.save(contactpersoon);
    }
}
