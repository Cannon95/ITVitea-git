package nl.cannontm.webserver.services;

import jakarta.transaction.Transactional;
import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClanService {

    @Autowired
    ClanRepository clanRepository;


    public Clan newClan(Clan clan){

        Clan repoClan = new Clan(clan.getTag(), clan.getName(), null);

        clanRepository.save(repoClan);
        return clan;
    }

    public List<Clan> getAllClans(){
        List<Clan> clans = new ArrayList<>();
        clanRepository.findAll().forEach(clans::add);
        clans.removeIf(clan -> clan.getId() == -1L);
        return clans;
    }

    public Optional<Clan> getClanbyID(Long id){
        return clanRepository.findById(id);
    }

    public Clan getOthersClan(){
        if(!clanRepository.existsById(-1L)){
            Clan clan = new Clan("null", "Other", new ArrayList<>());
            clan.setId(-1L);
            clan.setShouldTrack(0);
            return clanRepository.save(clan);
        }
        else{
            return clanRepository.findById(-1L).get();
        }
    }

    public Clan getClanFromTag(String tag){
        return clanRepository.findByTag(tag);
    }


    public boolean needsToUpdate(String clantag){ //check if it should update the clan
        Clan clan = getClanFromTag(clantag);
        if(clan.getShouldTrack() == 1 || clan.getShouldTrack() == 2)return true;
        else return false;
    }
    public boolean needsToTrack(String clantag){ //checks if it should track the clan e.g joining leaving players.
        Clan clan = getClanFromTag(clantag);
        if(clan.getShouldTrack() == 2)return true;
        else return false;
    }





}
