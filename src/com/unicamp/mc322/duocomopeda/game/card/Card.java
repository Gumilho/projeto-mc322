package com.unicamp.mc322.duocomopeda.game.card;

import java.util.ArrayList;

public abstract class Card {

    private String name;

    private int cost;

    private ArrayList<Effect> effects;

    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void getCost() {
        // TODO implement here
    }

    public void play() {
        // TODO implement here
    }

    public void toggleSelect() {
        // TODO implement here
    }

}