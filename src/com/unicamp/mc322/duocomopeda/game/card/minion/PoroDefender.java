
package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.player.Player;


public class PoroDefender extends Minion {
    
    public PoroDefender(Player owner) {
        super(
            "Poro Defender", 
            1, 
            1, 
            2, 
            EnumSet.noneOf(Trait.class),
            owner
        );
    }

    @Override
    public void onDeath(Player owner, Minion killed) {
        EffectManager.drawCard(owner, 1);
    }

}
