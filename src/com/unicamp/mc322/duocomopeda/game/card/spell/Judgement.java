package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.HitAllDefenders;

public class Judgement extends Spell {
    
    public Judgement() {
        super(
            "DE008", 
            "Judgement", 
            8,
            new Effect[]{
                new HitAllDefenders(false, EffectTrigger.ON_PLAY)
            }
        );
    }
}
