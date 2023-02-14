package nl.cannontm.webserver.services;

import nl.cannontm.webserver.config.BotConfig;
import nl.cannontm.webserver.models.Player;
import nl.cannontm.webserver.models.Progress;
import nl.cannontm.webserver.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

@Service
public class ProgressService {

    @Autowired
    ProgressRepository progressRepository;

    @Autowired
    PlayerService playerService;

    public Progress updateProgress(String tag){


        Progress progress = progressRepository.findByTag(tag);
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        LocalDate firstofMonth = LocalDate.of(date.getYear(), date.getMonth(), 1);
        long d = firstofMonth.toEpochDay()*1000*3600*24;
        Player player = playerService.getPlayerFromTag(tag);
        int curLabScore = player.getTroops().total() + player.getDarktroops().total() + player.getSieges().total() + player.getSpells().total();
        if(progress == null){ //if its null create new one here
            progress = new Progress();
            progress.setTag(tag);
            progress.setMonthlyHeroes(player.getHeroes().total());
            progress.setMonthlyLab(curLabScore);
            progress.setMonthlyPets(player.getPets().total());
            progress.setDatestamp(d);
            return progressRepository.save(progress);
        }
        //if already exists, check the date if it is outdated so Yes, Tell in Discord about progression.
        if(progress.getDatestamp() < d && d < System.currentTimeMillis() + 48*3600*1000){
            int divHeroes = progress.getMonthlyHeroes() - player.getHeroes().total();
            int divTroops = progress.getMonthlyLab() - curLabScore;
            int divPets = progress.getMonthlyPets() - player.getPets().total();


            BotConfig.log("Player has Progressed While out of the radar: Heroes: (" + progress.getMonthlyHeroes() + " -> " + player.getHeroes().total() + ")[+" + divHeroes + "], Lab: (" + progress.getMonthlyLab() + " -> " + curLabScore + ")[+" + divTroops + "], Pets: (" + progress.getMonthlyPets() + " -> " + player.getPets().total() + ")[+" + divPets + "]");

            progress.setMonthlyHeroes(player.getHeroes().total());
            progress.setMonthlyLab(curLabScore);
            progress.setMonthlyPets(player.getPets().total());
            progress.setDatestamp(d);

            return progress;

        }

        else return progress;


    }



}
