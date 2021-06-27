package com.unicamp.mc322.duocomopeda.game.card;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectEventFirer;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;

public class Minion extends Card implements Killable, EffectEventFirer {
    private Health health;
    private int power;
    private ArrayList<Trait> traits = new ArrayList<Trait>();
    private ArrayList<Effect> effects = new ArrayList<Effect>();
    private boolean isDead = false;

    public Minion(String name, int cost, int health, int power) {
        super(name, cost);
        this.power = power;
        this.health = new Health(health, this);
    }

    public void die() {
        onEffectEvent(EffectTrigger.ON_DEATH);
        isDead = true;
    }

    public void attack(Minion enemy) {
        // TODO: account for elusive
        onEffectEvent(EffectTrigger.ON_HIT);
        enemy.takeDamage(this.power);
        if (!enemy.isDead) {
            enemy.defend(this);
        } else {
            onEffectEvent(EffectTrigger.ON_KILL);
            // TODO: account for fury

        }
        // TODO: account for double attack
    }

    private void defend(Minion attacker) {
        // TODO: account for elusive
        onEffectEvent(EffectTrigger.ON_DEFENSE);
        attacker.takeDamage(this.power);
    }

    private void takeDamage(int amount) {
        onEffectEvent(EffectTrigger.ON_DAMAGE_TAKEN);
        health.takeDamage(amount);
    }

    @Override
    public void onEffectEvent(EffectTrigger trigger) {
        for (Effect e : effects) {
            if (e.getTrigger() == trigger) {
                e.activate();
            }
        }

    }

}