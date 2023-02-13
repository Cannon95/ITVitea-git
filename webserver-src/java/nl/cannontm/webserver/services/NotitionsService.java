package nl.cannontm.webserver.services;

import nl.cannontm.webserver.models.Notitions;
import nl.cannontm.webserver.repository.NotitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotitionsService {

    @Autowired
    NotitionRepository notitionRepository;

    public void addNotition(Notitions notitions){
        notitionRepository.save(notitions);
    }
    public void removeNotition(Long id){
        if(notitionRepository.existsById(id)){
            Notitions notitions = getNotition(id);
            notitionRepository.delete(notitions);
        }
    }

    public Notitions getNotition(Long id){
        if(notitionRepository.existsById(id)){
            return notitionRepository.findById(id).get();
        }
        else return null;
    }

}
