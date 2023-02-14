package nl.cannontm.webserver.services;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.interaction.InteractionCreateEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import nl.cannontm.webserver.listeners.EventListener;
import nl.cannontm.webserver.models.Clan;
import nl.cannontm.webserver.models.Notitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatInputInteractionService implements EventListener<ChatInputInteractionEvent> {

    @Autowired
    ClanService clanService;

    @Autowired
    CallAPIService callAPIService;

    @Autowired
    NotitionsService notitionsService;


    @Override
    public Class<ChatInputInteractionEvent> getEventType() {
        return ChatInputInteractionEvent.class;
    }


    @Override
    public Mono<Void> execute(ChatInputInteractionEvent event) { //missing check for if the interaction is not a ChatInputCommand...

        if(event.getCommandName().equals("addclan")){
            String tag = event.getOption("clantag").get().getValue().get().asString();
            Long tracking = event.getOption("tracking").get().getValue().get().asLong();
            try{
                Clan clan = callAPIService.getClan(tag);
                clan.setShouldTrack(tracking.intValue());
                clanService.newClan(clan);
            }
            catch(Exception e){
                return event.reply("de tag is niet goed, of er ging iets mis: " + e.getMessage());
            }


                return event.reply("clan toegevoegd");

        }
        else if(event.getCommandName().equals("addnotition")){
            try {
                String tag = event.getOption("spelertag").get().getValue().get().asString();
                String type = event.getOption("type").get().getValue().get().asString();
                String reden = event.getOption("reden").get().getValue().get().asString();

                Notitions notitions = new Notitions();
                notitions.setType(type);
                notitions.setDescription(reden);
                notitions.setTag(tag);

                return event.reply(notitionsService.addNotition(notitions));
            }
            catch(Exception e){
                return event.reply("er ging iets mis: " + e.getMessage());
            }
        }
        else if(event.getCommandName().equals("getnotition")){
            String tag = event.getOption("spelertag").get().getValue().get().asString();
            List<Notitions> notities = new ArrayList<>();

            notitionsService.getAllNotitionsByTag(tag).forEach(notities::add);

            EmbedCreateSpec.Builder builder = EmbedCreateSpec.builder()
                    .color(Color.YELLOW)
                    .title(notitionsService.getName(tag) + "'s Notes... ")
                    .description(notitionsService.getName(tag) + " heeft " + notities.size() + " Waarschuwingen.");

                    for(Notitions n : notities){
                        builder.addField("[" + n.getType() + "] " + n.getDescription(), "", false);
                    }
                    EmbedCreateSpec embed = builder.timestamp(Instant.now()).build();




                     event.getInteraction().getChannel()
                    .flatMap(messageChannel -> messageChannel.createMessage(embed)).subscribe();
            return event.reply("..");
        }
        else{
            return event.reply("unknown command");
        }
    }
}
