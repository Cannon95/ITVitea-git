package nl.cannontm.webserver.models;

public class Clan {

    private Player[] players;
    private String clanName;


    public Clan(Player[] players, String clanName) {
        this.players = players;
        this.clanName = clanName;
    }
}
