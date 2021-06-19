package com.unicamp.mc322.duocomopeda.game.card;

import java.util.*;

import com.unicamp.mc322.duocomopeda.stats.Health;
import com.unicamp.mc322.duocomopeda.stats.Killable;

public class Minion extends Card implements Killable {
    private Health health;
    private int power;
    private ArrayList<Trait> traits;

    public Minion(String name, int cost, int health, int power) {
        super(name, cost);
        this.power = power;
        this.health = new Health(health, this);
    }

    public void die() {
        // TODO implement here
    }

    public void attack() {
        // TODO implement here
    }

}