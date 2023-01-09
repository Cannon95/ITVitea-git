package nl.cannontm.webserver.models;

public class Player {

    private String playerTag;
    private int townHall;
    private int[] heroes;


    public Player(String playerTag, int townHall, int[] heroes) {
        this.playerTag = playerTag;
        this.townHall = townHall;
        this.heroes = heroes;
    }
}
