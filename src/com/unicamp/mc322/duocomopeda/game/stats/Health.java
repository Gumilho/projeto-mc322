package com.unicamp.mc322.duocomopeda.game.stats;

public class Health {

    private Killable owner;

    private int maxHealth;
    private int currentHealth;

    public Health(int maxHealth, Killable owner) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.owner = owner;
    }

    // avisar no projeto que existe um owner só pq minion morre diferente de player
    public void takeDamage(int amount) {
        currentHealth -= amount;
        if (currentHealth <= 0) {
            currentHealth = 0;
            owner.die();
        }
    }

    public void heal(int amount) {
        currentHealth += amount;
        if (currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
    }

}