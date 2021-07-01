package com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant;

import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.TargetedEffect;

//instant effects are applied immediately
public abstract class InstantEffect extends TargetedEffect {

    public InstantEffect(boolean repeatable, EffectTrigger trigger) {
        super(repeatable, trigger);
        // TODO Auto-generated constructor stub
    }

}
