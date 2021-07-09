package com.unicamp.mc322.duocomopeda.game.card;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.stats.Mana;

public abstract class Card {

    private String name;
    private String description;
    private int cost;
    private Player owner;

    public Card(String name, int cost, Player owner, String description) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.owner = owner;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Player getOwner() {
        return owner;
    }

    public abstract void play();

    public abstract void play(int cost);

    public abstract void displayDetails();

    public abstract boolean playable(Mana mana);

}