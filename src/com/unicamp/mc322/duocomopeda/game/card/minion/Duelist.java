package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.untargeted.draw.DrawSpecificCard;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;


public class Duelist extends Minion {
    
    public Duelist() {
        super(
            "DE004", 
            "Duelist", 
            3, 
            3, 
            2, 
            new Trait[]{}, 
            new Effect[]{
                new DrawSpecificCard(true, EffectTrigger.ON_OPPONENT_DEATH)
            }
        );
    }
}
