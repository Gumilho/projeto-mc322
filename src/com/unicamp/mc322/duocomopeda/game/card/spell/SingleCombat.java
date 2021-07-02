package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.Duel;

public class SingleCombat extends Spell {
    
    public SingleCombat() {
        super(
            "DE011", 
            "Single Combat", 
            2,
            new Effect[]{
                new Duel(false, EffectTrigger.ON_PLAY)
            }
        );
    }
}
