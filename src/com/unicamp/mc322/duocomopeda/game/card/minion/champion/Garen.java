package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.card.effect.targeted.instant.HealCompletely;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.mission.AttackMission;

public class Garen extends Champion {

    public Garen() {
        super(
            "DE001", 
            "Garen", 
            5, 
            5, 
            5, 
            new Trait[]{}, 
            new Effect[]{
                new HealCompletely(true, EffectTrigger.ON_ROUND_END)
            },
            new AttackMission(4, EffectTrigger.ON_DAMAGE_TAKEN)
        );
    }
}
