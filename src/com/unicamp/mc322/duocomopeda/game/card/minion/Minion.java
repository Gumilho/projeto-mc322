package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.ArrayList;
import java.util.Arrays;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.OnKillTrigger;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;

public class Minion extends Card implements Killable {

    private Health health;
    private int power;
    private ArrayList<Trait> traits = new ArrayList<Trait>();
    private ArrayList<Effect> effects = new ArrayList<Effect>();
    private boolean isDead = false;

    public Minion(String id, String name, int cost, int power, int health, Trait[] traits, Effect[] effects) {
        super(id, name, cost, effects);
        this.power = power;
        this.health = new Health(health, this);
        this.traits.addAll(Arrays.asList(traits));
    }

    public void die() {
        onEffectEvent(EffectTrigger.ON_DEATH);
        isDead = true;
    }

    public void attack(Minion enemy) {
        // TODO: account for elusive
        enemy.takeDamage(this.power);
        onEffectEvent(EffectTrigger.ON_HIT);
        if (!enemy.isDead) {
            enemy.defend(this);
        } else {
            onEffectEvent(EffectTrigger.ON_KILL);
            onEffectEvent(new OnKillTrigger(this.getOwner(), this, enemy));
            // TODO: account for fury

        }
        // TODO: account for double attack
        // fazer um overload no attack pra receber um int que multiplica
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

    public void onEffectEvent(OnKillTrigger trigger) {
        for (Effect e : effects) {
            if (e.getTrigger() == trigger.getTrigger()) {
                e.activate(trigger);
            }
        }
    }

}