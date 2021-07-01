package com.unicamp.mc322.duocomopeda.game.card.effect.targeted.temporary;

import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.TargetedEffect;

//temporary effects last until the end of the round
public abstract class TemporaryEffect extends TargetedEffect {

    public TemporaryEffect(boolean repeatable, EffectTrigger trigger) {
        super(repeatable, trigger);
        // TODO Auto-generated constructor stub
    }

}
