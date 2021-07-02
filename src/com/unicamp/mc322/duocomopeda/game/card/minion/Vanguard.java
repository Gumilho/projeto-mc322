package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.untargeted.BuffAllAllies;

public class Vanguard extends Minion {
    
    public Vanguard() {
        super(
            "DE003", 
            "Vanguard", 
            5, 
            5, 
            5, 
            new Trait[]{}, 
            new Effect[]{
                new BuffAllAllies(false, EffectTrigger.ON_PLAY)
            }
        );
    }
}
