package nl.cannontm.webserver.services;

import nl.cannontm.webserver.config.BotConfig;
import nl.cannontm.webserver.models.Notitions;
import nl.cannontm.webserver.repository.NotitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotitionsService {

    @Autowired
    NotitionRepository notitionRepository;

    @Autowired
    PlayerService playerService;

    public String addNotition(Notitions notitions){

        String name = playerService.getPlayerFromTag(notitions.getTag()).getName();
        notitions.setDate(System.currentTimeMillis());
        notitionRepository.save(notitions);
        return  name + " - " + notitions.getTag() + " - " + notitions.getType() + " - " + notitions.getDescription();

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

    public Iterable<Notitions> getAllNotitionsByTag(String tag){
        return notitionRepository.findByTag(tag);
    }

    public String getName(String tag) {
        return playerService.getPlayerFromTag(tag).getName();
    }
}
