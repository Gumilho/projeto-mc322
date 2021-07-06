package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

public class Mission {
    private int iterator = 0;
    private int goal;
    private boolean active = true;

    public Mission(int goal) {
        this.goal = goal;
    }

    void iterate(int amount, Champion owner) {
        if (!active) {
            return;
        }

        iterator += amount;
        if (iterator >= goal) {
            active = false;
            owner.upgrade();
        }
    }
}
