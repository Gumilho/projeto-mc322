package com.unicamp.mc322.duocomopeda.game.stats;

import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class MinionStats {

    private int power;
    private int tmpPower;
    private Health health;
    private Minion owner;

    public MinionStats(int power, int health, Minion owner) {
        this.power = power;
        this.health = new Health(health, owner);
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health.getCurrentHealth();
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

    public void buffOneRound(int power, int health) {
        this.tmpPower = power;
        this.health.addTmpHealth(health);
    }

    public void resetTmpStats() {
        this.tmpPower = 0;
        this.health.resetTmpHealth();
    }

    public void takeDamage(int amount) {
        this.health.takeDamage(amount);
    }

}
