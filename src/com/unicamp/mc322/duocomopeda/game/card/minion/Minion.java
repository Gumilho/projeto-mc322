package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Trait;
import com.unicamp.mc322.duocomopeda.game.event.handler.MinionEventHandler;
import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Minion extends Card implements Killable, MinionEventHandler {

    private Health health;
    private int power;
    private EnumSet<Trait> traits;
    private boolean isDead = false;

    public Minion(String name, int cost, int power, 
            int health, EnumSet<Trait> traits, Player owner) {
        super(name, cost, owner);
        this.power = power;
        this.health = new Health(health, this);
        this.traits = traits;
    }

    // Stat getters
    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health.getCurrentHealth();
    }

    // Stat changing methods
    public void die() {
        this.onDeath(this.getOwner(), this);
        isDead = true;
        Board board = Board.getInstance();
        board.remove(this);
    }

    public void buff(int power, int health) {
        this.power += power;
        this.health.increase(health);
    }

    public void healCompletely() {
        this.health.healCompletely();
    }

    public void doubleStats() {
        this.power *= 2;
        this.health.doubleStats();
    }

    protected void addTrait(Trait trait) {
        traits.add(trait);
    }

    // "Action" methods
    @Override
    public void play(Player owner) {
        this.onPlay(owner, this);
        Board board = Board.getInstance();
        board.placeUnit(this, owner.getIndex());
    }

    public void attack(Minion enemy) {
        // TODO: account for elusive
        if (traits.contains(Trait.DOUBLE_ATTACK)) {
            this.strike(enemy);
            if (!enemy.isDead) {
                this.strike(enemy);
                enemy.defend(this, this.power);
            }
        } else {
            this.strike(enemy);
            enemy.defend(this, this.power);
        }

        // fazer um overload no attack pra receber um int que multiplica
    }
    public void attack(Player player) {
        player.takeDamage(this.power);
    }

    public void strike(Minion enemy) {
        enemy.takeDamage(this.power);
        this.onHit(this.getOwner(), this, enemy, this.power);
        if (enemy.isDead) {
            this.onKill(this.getOwner(), this, enemy);
            // TODO: account for fury
        }

    }

    private void defend(Minion attacker, int attackerDamage) {
        // TODO: account for elusive
        this.onDefense(this.getOwner(), attacker, this, attackerDamage);
        attacker.takeDamage(this.power);
    }

    // Maybe it's public
    private void takeDamage(int amount) {
        this.onTakeDamage(this.getOwner(), this, amount);
        health.takeDamage(amount);
    }

    // default option for event is to do nothing
    public void onPlay(Player owner, Card playedCard) {

    }
    public void onKill(Player owner, Minion killer, Minion killed) {
        
    }
    public void onDeath(Player owner, Minion killed) {

    }
    public void onHit(Player owner, Minion attacker, Minion defender, int damage) {

    }
    public void onTakeDamage(Player owner, Minion target, int damage) {

    }
    public void onDefense(Player owner, Minion attacker, Minion defender, int damage) {

    }
    public void onRoundEnd(Player owner) {

    }

}