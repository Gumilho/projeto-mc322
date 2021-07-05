
package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectManager;


public class PoroDefender extends Minion {
    
    public PoroDefender(Player owner) {
        super(
            "Poro Defender", 
            1, 
            1, 
            2, 
            new Trait[]{}, 
            owner
        );
    }

    @Override
    public void onDeath(Player owner, Minion killed) {
        EffectManager.drawCard(owner, 1);
    }

}
