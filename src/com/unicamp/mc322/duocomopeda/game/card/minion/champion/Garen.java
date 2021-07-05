package com.unicamp.mc322.duocomopeda.game.card.minion.champion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectTrigger;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.mission.AttackMission;

public class Garen extends Champion {

    public Garen(Player owner) {
        super(
            "Garen", 
            5, 
            5, 
            5, 
            new Trait[]{}, 
            owner,
            new AttackMission(4, EffectTrigger.ON_DAMAGE_TAKEN)
        );
    }
}
