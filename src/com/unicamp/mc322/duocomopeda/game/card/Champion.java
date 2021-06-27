package com.unicamp.mc322.duocomopeda.game.card;

public class Champion extends Minion {
    private Mission mission;

    public Champion(String name, int cost, int health, int power, Mission mission) {
        super(name, cost, health, power);
        this.mission = mission;
    }

    // package private
    protected void upgrade() {

    }

    public void update() {
        // TODO implement here
    }

}