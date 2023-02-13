package nl.cannontm.webserver.services;

import nl.cannontm.webserver.models.*;
import nl.cannontm.webserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    HeroesRepository heroesRepository;

    @Autowired
    TroopsRepository troopsRepository;

    @Autowired
    DarkTroopsRepository darkTroopsRepository;

    @Autowired
    SiegesRepository siegesRepository;

    @Autowired
    SpellsRepository spellsRepository;

    @Autowired
    PetRepository petsRepository;






    public Heroes AddHeroesStat(Player player, Heroes heroes){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Add Heroes to nonExist Player");
            return null;
        }
        heroes.setPlayer(player);
        return heroesRepository.save(heroes);

    }

    public Troops AddTroopStat(Player player, Troops troops){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Add Troops to nonExist Player");
            return null;
        }
        troops.setPlayer(player);
       return troopsRepository.save(troops);

    }

    public DarkTroops AddDarkTroopStat(Player player, DarkTroops troops){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Add DarkTroops to nonExist Player");
            return null;
        }
        troops.setPlayer(player);
        return darkTroopsRepository.save(troops);

    }

    public Sieges AddSiegesStat(Player player, Sieges sieges){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Add Sieges to nonExist Player");
            return null;
        }
        sieges.setPlayer(player);
        return siegesRepository.save(sieges);

    }

    public Spells AddSpellsStat(Player player, Spells spells){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Add Spells to nonExist Player");
            return null;
        }
        spells.setPlayer(player);
        return spellsRepository.save(spells);

    }

    public Pets AddPetsStat(Player player, Pets pets){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Add Pets to nonExist Player");
            return null;
        }
        pets.setPlayer(player);
        return petsRepository.save(pets);

    }

    public Heroes updateHeroesStat(Player player, Heroes heroes){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update Heroes to nonExist Player");
            return null;
        }
        if(!heroesRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update nonExist Heroes");
            return null;
        }
        heroes.setId(player.getId());
        return heroesRepository.save(heroes);
    }

    public Troops updateTroopStat(Player player, Troops troops){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update Troops to nonExist Player");
            return null;
        }
        if(!troopsRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update nonExist Troops");
            return null;
        }
        troops.setId(player.getId());
        return troopsRepository.save(troops);
    }

    public DarkTroops updateDarkTroopsStat(Player player, DarkTroops darkTroops){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update DarkTroops to nonExist Player");
            return null;
        }
        if(!heroesRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update nonExist DarkTroops");
            return null;
        }
        darkTroops.setId(player.getId());
        return darkTroopsRepository.save(darkTroops);
    }


    public Sieges updateSiegesStat(Player player, Sieges sieges){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update Sieges to nonExist Player");
            return null;
        }
        if(!siegesRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update nonExist Sieges");
            return null;
        }
        sieges.setId(player.getId());
        return siegesRepository.save(sieges);
    }

    public Spells updateSpellsStat(Player player, Spells spells){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update Spells to nonExist Player");
            return null;
        }
        if(!heroesRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update nonExist Spells");
            return null;
        }
        spells.setId(player.getId());
        return spellsRepository.save(spells);
    }

    public Pets updatePetsStat(Player player, Pets pets){
        if(!playerRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update Pets to nonExist Player");
            return null;
        }
        if(!petsRepository.existsById(player.getId())){
            System.out.println("Error: Trying to Update nonExist Pets");
            return null;
        }
        pets.setId(player.getId());
        return petsRepository.save(pets);
    }




}
