package com.unicamp.mc322.duocomopeda.game.card.minion.champion.mission;

import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.Champion;

public abstract class Mission {
    private int iterator = 0;
    private int goal;
    private boolean active = true;
    private EffectTrigger trigger;

    public Mission(int goal, EffectTrigger trigger) {
        this.goal = goal;
        this.trigger = trigger;
    }

    // package private
    private void iterate(int amount, Champion owner) {
        if (!active) {
            return;
        }

        iterator += amount;
        if (iterator >= goal) {
            active = false;
            owner.upgrade();
        }
    }

    // TODO: find a way to activate
    // TODO: find a way to track champion damage

}
