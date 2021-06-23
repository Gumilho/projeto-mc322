package com.unicamp.mc322.duocomopeda.game.card;

import java.util.*;

import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;

public class Minion extends Card implements Killable {
    private Health health;
    private int power;
    private ArrayList<Trait> traits;
    private boolean isDead = false;

    public Minion(String name, int cost, int health, int power) {
        super(name, cost);
        this.power = power;
        this.health = new Health(health, this);
    }

    public void die() {
        // TODO: disparar evento ON_DEATH
        isDead = true;
    }

    public void attack(Minion enemy) {
        // TODO: disparar evento ON_ATTACK
        enemy.takeDamage(this.power);
        if (!enemy.isDead) {
            enemy.defend(this);
        }
    }

    private void defend(Minion attacker) {
        // TODO: disparar evento ON_DEFEND
        attacker.takeDamage(this.power);
    }

    private void takeDamage(int amount) {
        // TODO: disparar evento ON_DAMAGE_TAKEN
        health.takeDamage(amount);
    }

}