package com.unicamp.mc322.duocomopeda.game.card.traits;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;

public abstract class Trait extends Effect {

    public Trait(EffectTrigger trigger) {
        super(true, trigger);
    }

}