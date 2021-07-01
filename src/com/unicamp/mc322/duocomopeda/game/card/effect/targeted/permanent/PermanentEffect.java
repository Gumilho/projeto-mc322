package com.unicamp.mc322.duocomopeda.game.card.effect.targeted.permanent;

import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.TargetedEffect;

//permanent effects are applied immediately and last forever
public abstract class PermanentEffect extends TargetedEffect {

    public PermanentEffect(boolean repeatable, EffectTrigger trigger) {
        super(repeatable, trigger);
        // TODO Auto-generated constructor stub
    }

}
