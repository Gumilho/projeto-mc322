package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.mission.Mission;

public class Champion extends Minion {
    private Mission mission;

    public Champion(String id, String name, int cost, int power, int health, Trait[] traits, Effect[] effects, Mission mission) {
        super(id, name, cost, power, health, traits, effects);
        this.mission = mission;
    }

    public void upgrade() {

    }

    public void update() {
        // TODO implement here
    }

}