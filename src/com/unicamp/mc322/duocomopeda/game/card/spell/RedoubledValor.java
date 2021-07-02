package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.HealCompletely;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.permanent.DoubleStats;

public class RedoubledValor extends Spell {
    
    public RedoubledValor() {
        super(
            "DE009", 
            "Redoubled Valor", 
            6,
            new Effect[]{
                new HealCompletely(false, EffectTrigger.ON_PLAY),
                new DoubleStats(false, EffectTrigger.ON_PLAY)
            }
        );
    }
}
