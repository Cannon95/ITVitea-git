package nl.cannontm.webserver.services;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.interaction.InteractionCreateEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import nl.cannontm.webserver.listeners.EventListener;
import nl.cannontm.webserver.models.Clan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChatInputInteractionService implements EventListener<ChatInputInteractionEvent> {

    @Autowired
    ClanService clanService;

    @Autowired
    CallAPIService callAPIService;

    @Override
    public Class<ChatInputInteractionEvent> getEventType() {
        return ChatInputInteractionEvent.class;
    }


    @Override
    public Mono<Void> execute(ChatInputInteractionEvent event) { //missing check for if the interaction is not a ChatInputCommand...

        if(event.getCommandName().equals("addclan")){
            String tag = event.getOption("clantag").get().getValue().get().asString();
            long tracking = event.getOption("tracking").get().getValue().get().asLong();
            try{
                Clan clan = callAPIService.getClan(tag);
                clan.setShouldTrack((int)tracking);
                clanService.newClan(clan);
            }
            catch(Exception e){
                return event.reply("de tag is niet goed, of er ging iets mis: " + e.getMessage());
            }


                return event.reply("clan toegevoegd");

        }
        else if(event.getCommandName().equals("addnotition")){
            return event.reply("nog in opbouw");
        }
        else{
            return event.reply("unknown command");
        }







    }
}
