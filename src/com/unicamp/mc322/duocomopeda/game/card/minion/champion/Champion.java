package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.mission.Mission;

public class Champion extends Minion {

    private Mission mission;

    public Champion(String name, int cost, int power, int health, Trait[] traits, Player owner, Mission mission) {
        super(name, cost, power, health, traits, owner);
        this.mission = mission;
    }

    public void upgrade() {

    }

    public void update() {
        // TODO implement here
    }

    @Override
    public void onRoundEnd(Player owner) {
        EffectManager.healCompletely(this);
    }

}