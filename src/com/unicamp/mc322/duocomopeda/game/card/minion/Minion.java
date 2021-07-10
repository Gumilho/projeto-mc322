package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.event.MinionEventHandler;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;
import com.unicamp.mc322.duocomopeda.game.stats.Mana;
import com.unicamp.mc322.duocomopeda.game.stats.MinionStats;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Minion extends Card implements Killable, MinionEventHandler {

    private MinionStats stats;
    private EnumSet<Trait> traits;
    private boolean isDead;
    private boolean barrierActive;

    public Minion(String name, int cost, int power, int health, EnumSet<Trait> traits, Player owner,
            String description) {
        super(name, cost, owner, description);
        this.stats = new MinionStats(power, health, this);
        this.traits = traits;
        this.isDead = false;
        this.barrierActive = false;
    }

    // Stat getters
    public int getPower() {
        return stats.getPower();
    }

    public int getHealth() {
        return stats.getHealth();
    }

    public boolean isElusive() {
        return traits.contains(Trait.ELUSIVE);
    }

    @Override
    public boolean playable(Mana mana) {
        return getCost() <= mana.getCurrentMana();
    }

    @Override
    public String getDetails() {
        return String.format("Card name: %s | Mana Cost: %d\nPower: %d | Health: %d\nDescription: %s", getName(),
                getCost(), getPower(), getHealth(), getDescription());
    }

    // Stat changing methods
    public void die() {
        this.onDeath(this);
        isDead = true;
        Board board = Board.getInstance();
        board.remove(this);
    }

    public void buff(int power, int health) {
        this.stats.buff(power, health);
    }

    public void healCompletely() {
        this.stats.healCompletely();
    }

    public void doubleStats() {
        this.stats.doubleStats();
    }

    public void buffOneRound(int power, int health) {
        this.stats.buffOneRound(power, health);
    }

    public void addBarrier() {
        this.barrierActive = true;
    }

    protected void addTrait(Trait trait) {
        traits.add(trait);
    }

    // "Action" methods
    @Override
    public void play() {
        Player player = getOwner();
        player.useMana(this.getCost());
        this.onPlay(this);
        Board board = Board.getInstance();
        board.placeUnit(this, getOwner());
    }

    @Override
    public void play(int cost) {
        Player player = getOwner();
        player.useMana(cost);
        this.onPlay(this);
        Board board = Board.getInstance();
        board.placeUnit(this, getOwner());
    }

    public void attack(Minion enemy) {
        if (traits.contains(Trait.DOUBLE_ATTACK)) {
            this.strike(enemy);
        }
        if (!enemy.isDead) {
            this.strike(enemy);
            enemy.defend(this, this.stats.getPower());
        }

    }

    public void attack(Player player) {
        player.takeDamage(this.stats.getPower());
    }

    public void strike(Minion enemy) {
        enemy.takeDamage(this.stats.getPower());
        this.onHit(this, enemy, this.stats.getPower());
        if (enemy.isDead) {
            this.onKill(this, enemy);
        }

    }

    private void defend(Minion attacker, int attackerDamage) {
        this.onDefense(attacker, this, attackerDamage);
        attacker.takeDamage(this.stats.getPower());
        if (attacker.isDead) {
            this.onKill(this, attacker);
        }
    }

    // Maybe it's public
    private void takeDamage(int amount) {
        if (!barrierActive) {
            this.onTakeDamage(this, amount);
            this.stats.takeDamage(amount);
        }
        barrierActive = false;
    }

    public void zeroPower() {
        this.stats.zeroPower();
    }

    // default option for event is to do nothing
    public void onPlay(Card playedCard) {

    }

    public void onKill(Minion killer, Minion killed) {

    }

    public void onDeath(Minion killed) {

    }

    public void onHit(Minion attacker, Minion defender, int damage) {

    }

    public void onTakeDamage(Minion target, int damage) {

    }

    public void onDefense(Minion attacker, Minion defender, int damage) {

    }

    public void onRoundEnd() {
        this.stats.resetTmpStats();
    }

}