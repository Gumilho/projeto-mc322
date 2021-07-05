package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectManager;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Duelist extends Minion {
    
    public Duelist(Player owner) {
        super(
            "Duelist", 
            3, 
            3, 
            2, 
            new Trait[]{},
            owner
        );
    }

    @Override
    public void onKill(Player owner, Minion killer, Minion killed) {
        EffectManager.drawSpecificCard(owner, "Poro");
    }

}
