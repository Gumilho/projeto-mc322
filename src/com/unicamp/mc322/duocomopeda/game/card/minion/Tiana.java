package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.AttackNexus;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;

public class Tiana extends Minion {
    
    public Tiana() {
        super(
            "DE002", 
            "Tiana", 
            8, 
            7, 
            7, 
            new Trait[]{}, 
            new Effect[]{
                new AttackNexus(false, EffectTrigger.ON_PLAY)
            }
        );
    }
}
