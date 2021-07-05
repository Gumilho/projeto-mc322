package com.unicamp.mc322.duocomopeda.game.card;

import java.util.ArrayList;
import java.util.Arrays;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Card {

    private String name;
    private int cost;
    private Player owner;

    // se inscrever em eventos
    // e tb publicar eventos

    public Card(String name, int cost, Player owner) {
        this.name = name;
        this.cost = cost;
        this.owner = owner;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public abstract void play(Player owner);

    public void toggleSelect() {
        // TODO implement here
    }

}