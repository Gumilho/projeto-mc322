package com.unicamp.mc322.duocomopeda.game.card;

import java.util.ArrayList;
import java.util.Arrays;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;

public abstract class Card implements Cloneable{


    private String id;
    private String name;
    private int cost;
    protected ArrayList<Effect> effects;

    // se inscrever em eventos
    // e tb publicar eventos

    public void setCost(int n) {
        cost = n;
    }

    public Card(String id, String name, int cost, Effect[] effects) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.effects.addAll(Arrays.asList(effects));
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void play() {
        // TODO implement here
    }

    public void toggleSelect() {
        // TODO implement here
    }

    public boolean hasID(String cardID) {
        return id.equals(cardID);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}