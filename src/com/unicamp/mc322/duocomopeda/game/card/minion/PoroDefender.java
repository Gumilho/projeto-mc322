
package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.untargeted.draw.DrawRandomCard;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;


public class PoroDefender extends Minion {
    
    public PoroDefender() {
        super(
            "DE007", 
            "Poro Defender", 
            1, 
            1, 
            2, 
            new Trait[]{}, 
            new Effect[]{
                new DrawRandomCard(false, EffectTrigger.ON_DEATH)
            }
        );
    }
}
