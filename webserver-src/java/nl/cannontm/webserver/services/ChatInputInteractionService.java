package nl.cannontm.webserver.services;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.interaction.InteractionCreateEvent;
import nl.cannontm.webserver.listeners.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChatInputInteractionService implements EventListener<ChatInputInteractionEvent> {


    @Override
    public Class<ChatInputInteractionEvent> getEventType() {
        return ChatInputInteractionEvent.class;
    }


    @Override
    public Mono<Void> execute(ChatInputInteractionEvent event) { //missing check for if the interaction is not a ChatInputCommand...
        return event.reply("test");





    }
}
