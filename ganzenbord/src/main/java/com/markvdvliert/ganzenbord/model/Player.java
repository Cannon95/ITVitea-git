package com.markvdvliert.ganzenbord.model;

public class Player {

    private String color;
    private String playerName;
    private int position;
    private EnumStatus status;

    public Player(String playerName,String color, int position, EnumStatus status) {
        this.playerName = playerName;
        this.color = color;
        this.position = position;
        this.status = status;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

