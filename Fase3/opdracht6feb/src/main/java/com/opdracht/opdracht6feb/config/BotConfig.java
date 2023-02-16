package com.opdracht.opdracht6feb.config;


import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BotConfig {

    @Value("${token}")
    private String token;

    @Bean
    public <T extends Event>GatewayDiscordClient gatewayDiscordClient(List<IEvent<T>> handlers){
        final GatewayDiscordClient gateway = DiscordClientBuilder.create(token).build().login().block();

        try {
            new CommandRegistry(gateway.getRestClient()).registerCommands();
        } catch (Exception e) {
            System.err.println("an error happened while Registering commands: " + e);
        }

        for(IEvent<T> handler : handlers){
            gateway.on(handler.getEventType())
                    .flatMap(handler::execute)
                    .onErrorResume(handler::handleError)
                    .subscribe();
        }
        return gateway;
    }

}
