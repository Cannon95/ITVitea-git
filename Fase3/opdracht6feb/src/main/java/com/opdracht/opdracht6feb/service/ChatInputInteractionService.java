package com.opdracht.opdracht6feb.service;


import com.opdracht.opdracht6feb.config.IEvent;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

import discord4j.core.object.command.Interaction;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChatInputInteractionService implements IEvent<ChatInputInteractionEvent> {


    @Override
    public Class<ChatInputInteractionEvent> getEventType() {
        return ChatInputInteractionEvent.class;
    }

    @Override
    public Mono<Void> execute(ChatInputInteractionEvent event) {

        if(event.getCommandName().equals("hallo")){
            return event.reply("Hallo " +event.getOption("naam").get().getValue().get().asString());
        }
        else{
            return event.reply("Unknown Command Name.");
        }

    }
}
