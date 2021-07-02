package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.temporary.BuffSingle;

public class RadiantStrike extends Spell {
    
    public RadiantStrike() {
        super(
            "DE010", 
            "Radiant Strike", 
            1,
            new Effect[]{
                new BuffSingle(false, EffectTrigger.ON_PLAY)
            }
        );
    }
}
