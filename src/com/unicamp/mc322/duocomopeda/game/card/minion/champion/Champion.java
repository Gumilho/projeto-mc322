package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.card.minion.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public abstract class Champion extends Minion {

    private Mission mission;

    public Champion(String name, int cost, int power, int health, 
            EnumSet<Trait> traits, Player owner, int goal, 
            String description) {
        super(name, cost, power, health, traits, owner, description);
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