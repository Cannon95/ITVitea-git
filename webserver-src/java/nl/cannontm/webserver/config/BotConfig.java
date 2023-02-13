package nl.cannontm.webserver.config;


import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.RestClient;
import discord4j.rest.util.Color;
import nl.cannontm.webserver.listeners.EventListener;
import nl.cannontm.webserver.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

@Configuration
public class BotConfig {

    @Value("${token}")
    private String token;


    private static String joinChannel = "1074671041550491698";


    private static String eventChannel = "1074671008847495189";
    private static GatewayDiscordClient client;



    @Bean
    public <T extends Event>GatewayDiscordClient gatewayDiscordClient(final List<EventListener<T>> eventListeners) {
        client = DiscordClientBuilder.create(token).build().gateway().setInitialPresence(ignore -> ClientPresence.online(ClientActivity.watching("Jouw Attack"))).login().block();

        for(final EventListener<T> listener: eventListeners){
            client.on(listener.getEventType())
                    .flatMap(listener::execute)
                    .onErrorResume(listener::handleError)
                    .subscribe();
        }

        return client;
    }

    @Bean
    public RestClient discordRestClient(GatewayDiscordClient client) {
        return client.getRestClient();
    }

    public static void log(String message){
        client.getChannelById(Snowflake.of(eventChannel))
                .cast(TextChannel.class)
                .flatMap(textChannel -> textChannel.createMessage(message))
                .subscribe();

    }

    public static void onPlayerJoin(Player player) {

        int heroCount = player.getHeroes().total();
        int labCount = calcLab(player);
        Color color = Color.of(0x00FF00);
        boolean isToLow = false;
        if(heroCount < 120 || labCount < 180){
            color = Color.of(0xFF8800);
        }

        Heroes h = player.getHeroes();
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .color(color)
                .title(player.getName() + " Joined!")
                .description("TH" + player.getTownHallLevel())
                .addField("Heroes: " + player.getHeroes().total(), "[" + h.getKing() + "/" + h.getQueen() + " / " + h.getWarden() + " / " + h.getChampion() + "]" , false)
                .addField("\u200B", "\u200B", false)
                .addField("Lab: " + labCount, "\u200B", false)
                .addField("\u200B", "\u200B", false)
                .addField("Pets: " + player.getPets().total(), "\u200B", false)
                .timestamp(Instant.now())
                .build();

        client.getChannelById(Snowflake.of(joinChannel))
                .cast(TextChannel.class)
                .flatMap(textChannel -> textChannel.createMessage(embed))
                .subscribe();

        client.getChannelById(Snowflake.of(joinChannel))
                .cast(TextChannel.class)
                .flatMap(textChannel -> textChannel.createMessage("@everyone , rusher of te lage speler???"))
                .subscribe();
    }


    private static int calcLab(Player player){
        int t = player.getTroops().total();
        int d = player.getDarktroops().total();
        int z = player.getSieges().total();
        int s = player.getSpells().total();

        return t + d + z + s;
    }


}


