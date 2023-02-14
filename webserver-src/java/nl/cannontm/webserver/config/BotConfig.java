package nl.cannontm.webserver.config;


import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.object.entity.channel.VoiceChannel;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.VoiceChannelEditSpec;
import discord4j.rest.RestClient;
import discord4j.rest.util.Color;
import nl.cannontm.webserver.listeners.EventListener;
import nl.cannontm.webserver.models.*;
import nl.cannontm.webserver.services.ClanService;
import nl.cannontm.webserver.services.NotitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

@Configuration
public class BotConfig {

    @Value("${token}")
    private String token;


    private static String joinChannel = "1071774210151694337";
    private static String QueueVChannel = "1074734961854271548";

    private static String eventChannel = "1073987243406000170";
    private static GatewayDiscordClient client;

    @Autowired
    ClanService clanService;


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

    public static void onPlayerLeft(String message){
        client.getChannelById(Snowflake.of(joinChannel))
                .cast(TextChannel.class)
                .flatMap(textChannel -> textChannel.createMessage(message))
                .subscribe();

    }

    public static void setQueueShowChannel(int size){
        System.out.println("Showing QueueSize: " + size);
        client.getChannelById(Snowflake.of(QueueVChannel))
                .cast(VoiceChannel.class)
                .map(voiceChannel -> voiceChannel.edit().name("Queue: " + size).subscribe())
                .subscribe();
    }

    public static void onPlayerJoin(Player player, Clan clan, List<Notitions> notitions) {

        int heroCount = player.getHeroes().total();
        int labCount = calcLab(player);
        Color color = Color.of(0x00FF00);

        if(heroCount < 120 || labCount < 180){
            color = Color.of(0xFF8800);
        }
        Heroes h = player.getHeroes();
        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .color(color)
                .title(player.getName() + " Joined " + clan.getName() + " !")
                .description("TH" + player.getTownHallLevel())
                .addField("Heroes: " + player.getHeroes().total(), "[" + h.getKing() + " / " + h.getQueen() + " / " + h.getWarden() + " / " + h.getChampion() + "]" , false)
                .addField("Lab: " + labCount, "", false)
                .addField("Pets: " + player.getPets().total(), "", false)
                .addField("Warns: " + notitions.size(), "", false)
                .timestamp(Instant.now())
                .build();

        client.getChannelById(Snowflake.of(joinChannel))
                .cast(TextChannel.class)
                .flatMap(textChannel -> textChannel.createMessage(embed))
                .subscribe();
        if(player.getClanTag().equals("#28UC9CQ9V") && (player.getHeroes().total() < 120 || labCount < 180)){
            client.getChannelById(Snowflake.of(joinChannel))
                    .cast(TextChannel.class)
                    .flatMap(textChannel -> textChannel.createMessage("@everyone , rusher of te lage speler???"))
                    .subscribe();
        }
        if(player.getClanTag().equals("#2YPPLQ9QL") && (player.getHeroes().total() < 90 || labCount < 105)){
            client.getChannelById(Snowflake.of(joinChannel))
                    .cast(TextChannel.class)
                    .flatMap(textChannel -> textChannel.createMessage("@everyone , rusher of te lage speler???"))
                    .subscribe();
        }
        for (Notitions notition : notitions){
            if(notition.getType().equals("blacklist")){
                client.getChannelById(Snowflake.of(joinChannel))
                        .cast(TextChannel.class)
                        .flatMap(textChannel -> textChannel.createMessage("@everyone , Deze speler staat op de blacklist!"))
                        .subscribe();
                return;
            }
        }

    }





    private static int calcLab(Player player){
        int t = player.getTroops().total();
        int d = player.getDarktroops().total();
        int z = player.getSieges().total();
        int s = player.getSpells().total();

        return t + d + z + s;
    }


}


