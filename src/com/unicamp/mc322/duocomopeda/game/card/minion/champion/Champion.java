package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public abstract class Champion extends Minion {

    private Mission mission;

    public Champion(String name, int cost, int power, int health, Trait[] traits, Player owner, int goal) {
        super(name, cost, power, health, traits, owner);
        this.mission = new Mission(goal);
    }

    public void incrementMission(int amount) {
        mission.iterate(amount, this);
    }

    abstract void upgrade();

    @Override
    public void onRoundEnd(Player owner) {
        EffectManager.healCompletely(this);
    }

}