package nl.cannontm.webserver.services;

import nl.cannontm.webserver.models.*;
import nl.cannontm.webserver.repository.ClanRepository;
import nl.cannontm.webserver.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class PlayerService {

    @Autowired
    ClanRepository clanRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    StatService statService;

    public Player newPlayer(Clan clan, Player player){


        if(!clanRepository.existsById(clan.getId())){
            System.out.println("Error: Trying to Add Player to nonExist Clan");
            return null;
        }
        player.setClan(clan);
        Player newPlayer = new Player(player.getTag(), player.getName(), player.getTownHallLevel(), player.getOwnedBy(), player.getClan());
        playerRepository.save(newPlayer);
        newPlayer = addStatstoPlayer(getIdFromPlayer(player.getTag()), player.getHeroes(), player.getTroops(), player.getDarktroops(), player.getSieges(), player.getSpells(), player.getPets());


        System.out.println("Creating and Adding player " + player.getName() + " to database Done");
        return newPlayer;
    }

    public Player addStatstoPlayer(Long id, Heroes heroes, Troops troops, DarkTroops darkTroops, Sieges sieges, Spells spells, Pets pets){
        if(playerRepository.existsById(id)){
            Player player = playerRepository.findById(id).get();

            Heroes tempHeroes = statService.AddHeroesStat(player, heroes);
            Troops tempTroops = statService.AddTroopStat(player, troops);
            DarkTroops tempDarkTroops = statService.AddDarkTroopStat(player, darkTroops);
            Sieges tempSieges = statService.AddSiegesStat(player,sieges);
            Spells tempSpells = statService.AddSpellsStat(player, spells);
            Pets tempPets = statService.AddPetsStat(player, pets);

            player.setHeroes(tempHeroes);
            player.setTroops(tempTroops);
            player.setDarktroops(tempDarkTroops);
            player.setSieges(tempSieges);
            player.setSpells(tempSpells);
            player.setPets(tempPets);

            return playerRepository.save(player);

        }
        else return null;
    }


    public Player updatePlayer(Clan clan, Player player){
        if(!clanRepository.existsById(clan.getId())){
            System.out.println("Error: Trying to update Player to nonExist Clan");
            return null;
        }
        Player oldPlayer = getPlayerFromTag(player.getTag());
        if(oldPlayer == null){
            System.out.println("Player " + player.getName() +" not found in database, creating the player instead");
            return newPlayer(clan, player);
        }
        oldPlayer.setClan(clan);
        statService.updateHeroesStat(oldPlayer, player.getHeroes());
        statService.updateTroopStat(oldPlayer, player.getTroops());
        statService.updateDarkTroopsStat(oldPlayer, player.getDarktroops());
        statService.updateSiegesStat(oldPlayer, player.getSieges());
        statService.updateSpellsStat(oldPlayer, player.getSpells());
        statService.updatePetsStat(oldPlayer, player.getPets());
        oldPlayer.setDate_check(System.currentTimeMillis());
        return oldPlayer;
    }

    public Player getPlayerFromTag(String tag){
        Iterable <Player> playerlist = playerRepository.findAll();
        while(playerlist.iterator().hasNext()){
            Player player = playerlist.iterator().next();
            if(player.getTag().equals(tag)){
                return player;
            }
        }
        return null;
    }

    public List<Player> getUpdatablePlayers(){
        List<Player> playerlist = new ArrayList<>();
        playerRepository.findAll().forEach(playerlist::add);


        playerlist.removeIf(player -> player.getClan().getId() == -1L && player.getOwnedBy().equals("null")); // removes player from list if it is not in a managed clan and not owned by someone in the core of the clan
        playerlist.removeIf(player -> System.currentTimeMillis() - player.getDate_check() < 1000*3600*12); //removes te player if the date is shorter than 12 hours ago.

        return playerlist;
    }
    public Long getIdFromPlayer(String tag){
        List<Player> playerlist = new ArrayList<>();
        playerRepository.findAll().forEach(playerlist::add);
        playerlist = playerlist.stream().filter(player1 -> player1.getTag().equals(tag)).toList();
        if(!playerlist.isEmpty()){
            return playerlist.get(0).getId();
        }
        else return null;
    }



}
