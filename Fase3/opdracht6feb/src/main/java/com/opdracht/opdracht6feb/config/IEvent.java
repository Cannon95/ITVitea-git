package com.opdracht.opdracht6feb.config;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

public interface IEvent<T extends Event> {

    Class<T> getEventType();

    Mono<Void> execute(T event);

    default Mono<Void> handleError(final Throwable throwable){

        System.out.println("An error occured during firing Event. " + throwable.getMessage());
        return Mono.empty();
    }

}
