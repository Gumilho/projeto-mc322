package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.mission.Mission;

public class Champion extends Minion {
    private Mission mission;

    public Champion(String name, int cost, int health, int power, Mission mission) {
        super(name, cost, health, power);
        this.mission = mission;
    }

    public void upgrade() {

    }

    public void update() {
        // TODO implement here
    }

}