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

    public void takeDamage(int ammount) {
        currentHealth -= ammount;
        if (currentHealth <= 0) {
            currentHealth = 0;
            owner.die();
        }
    }

    public void heal(int ammount) {
        currentHealth += ammount;
        if (currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
    }

}