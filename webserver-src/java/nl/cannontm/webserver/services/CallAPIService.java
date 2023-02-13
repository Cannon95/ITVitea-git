package nl.cannontm.webserver.services;

import nl.cannontm.webserver.models.*;
import nl.cannontm.webserver.models.APImodels.APIHeroes;
import nl.cannontm.webserver.models.APImodels.APIPlayer;
import nl.cannontm.webserver.models.APImodels.APISpells;
import nl.cannontm.webserver.singleton.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class CallAPIService {



    @Value("${coc_token}")
    private String coc_token;


    public Clan getClan(String tag) {

        ;
        URI url = URI.create("https://api.clashofclans.com/v1/clans/%23" + tag.substring(1));
        return WebClient.create()
                .get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(coc_token))
                .retrieve()
                .bodyToMono(Clan.class)
                .map(clan -> {
                    String tag1 = clan.getTag();
                    String name = clan.getName();
                    List<Player> memberList = clan.getMemberList().stream().map(player -> {
                        String tag2 = player.getTag();
                        String name1 = player.getName();
                        return new Player(tag2,name1);
                    }).collect(Collectors.toList());
                    Clan clan2 = new Clan(tag1, name, memberList);
                    return clan2;
                }).block();

    }


    public Player getPlayer(String tag){

            URI url = URI.create("https://api.clashofclans.com/v1/players/%23" + tag.substring(1));
        return WebClient.create()
                .get()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(coc_token))
                .retrieve()
                .bodyToMono(APIPlayer.class)
                .map(apiPlayer -> {
                    Player player = new Player();
                    player.setTag(apiPlayer.getTag());
                    player.setName(apiPlayer.getName());
                    player.setTownHallLevel(apiPlayer.getTownHallLevel());
                    player.setClanTag(apiPlayer.getClan().getTag());
                    //Heroes
                    Heroes heroes = new Heroes();
                    apiPlayer.getHeroes().stream().forEach(apiHeroes -> {
                        System.out.println("Hero Name: " + apiHeroes.getName() + " " + apiHeroes.getLevel());
                        if(apiHeroes.getName().equals("Barbarian King"))heroes.setKing(apiHeroes.getLevel());
                        if(apiHeroes.getName().equals("Archer Queen"))heroes.setQueen(apiHeroes.getLevel());
                        if(apiHeroes.getName().equals("Grand Warden"))heroes.setWarden(apiHeroes.getLevel());
                        if(apiHeroes.getName().equals("Royal Champion"))heroes.setChampion(apiHeroes.getLevel());

                    });


                    Troops troops = new Troops();
                    DarkTroops darktroops = new DarkTroops();
                    Sieges sieges = new Sieges();
                    Pets pets = new Pets();
                    Spells spells = new Spells();
                    apiPlayer.getTroops().forEach(apiTroops -> {
                        //Troops
                        if(apiTroops.getName().equals("Barbarian"))troops.setBarbarian(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Archer"))troops.setArcher(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Goblin"))troops.setGoblin(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Giant"))troops.setGiant(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Wall Breaker"))troops.setWallbreaker(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Balloon"))troops.setBalloon(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Wizard"))troops.setWizard(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Healer"))troops.setHealer(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Dragon"))troops.setDragon(apiTroops.getLevel());
                        if(apiTroops.getName().equals("P.E.K.K.A"))troops.setPekka(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Baby Dragon") && apiTroops.getVillage().equals("home"))troops.setBabydragon(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Miner"))troops.setMiner(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Yeti"))troops.setYeti(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Electro Dragon"))troops.setElectrodragon(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Dragon Rider"))troops.setDragonrider(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Electro Titan"))troops.setElectrotitan(apiTroops.getLevel());

                        //Dark Troops
                        if(apiTroops.getName().equals("Minion"))darktroops.setMinion(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Hog Rider"))darktroops.setHogrider(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Valkyrie"))darktroops.setValkyrie(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Golem"))darktroops.setGolem(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Witch"))darktroops.setWitch(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Lava Hound"))darktroops.setLavahound(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Bowler"))darktroops.setBowler(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Ice Golem"))darktroops.setIcegolem(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Headhunter"))darktroops.setHeadhunter(apiTroops.getLevel());


                        //Sieges
                        if(apiTroops.getName().equals("Wall Wrecker"))sieges.setWallwrecker(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Battle Blimp"))sieges.setBattleblimp(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Stone Slammer"))sieges.setStoneslammer(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Siege Barracks"))sieges.setSiegebarracks(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Log Launcher"))sieges.setLoglauncher(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Flame Flinger"))sieges.setFlameflinger(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Battle Drill"))sieges.setBattledrill(apiTroops.getLevel());

                        //Pets
                        if(apiTroops.getName().equals("L.A.S.S.I"))pets.setLassi(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Mighty Yak"))pets.setYak(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Electro Owl"))pets.setOwl(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Unicorn"))pets.setUnicorn(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Phoenix"))pets.setPhoenix(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Poison Lizard"))pets.setLizard(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Diggy"))pets.setDiggy(apiTroops.getLevel());
                        if(apiTroops.getName().equals("Frosty"))pets.setFrosty(apiTroops.getLevel());


                    });
                    //Spells
                    apiPlayer.getSpells().forEach(apiSpells -> {
                        if(apiSpells.getName().equals("Lightning Spell"))spells.setLightning(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Healing Spell"))spells.setHeal(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Rage Spell"))spells.setRage(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Jump Spell"))spells.setJump(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Freeze Spell"))spells.setFreeze(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Poison Spell"))spells.setPoison(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Earthquake Spell"))spells.setEarthquake(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Haste Spell"))spells.setHaste(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Clone Spell"))spells.setClone(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Skeleton Spell"))spells.setSkeleton(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Bat Spell"))spells.setBat(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Invisibility Spell"))spells.setInvisible(apiSpells.getLevel());
                        if(apiSpells.getName().equals("Recall Spell"))spells.setRecall(apiSpells.getLevel());


                    });
                    player.setHeroes(heroes);
                    player.setTroops(troops);
                    player.setDarktroops(darktroops);
                    player.setSieges(sieges);
                    player.setSpells(spells);
                    player.setPets(pets);
                    System.out.println("Player " + player.getName() + " Loaded from API");
                    return player;
                }).block();

        }








}
