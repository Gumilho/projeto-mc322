
package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class PoroDefender extends Minion {

    public PoroDefender(Player owner) {
        super("Poro Defender", 1, 1, 2, EnumSet.noneOf(Trait.class), owner,
                "Effect: When this unit dies, draw one card");
    }

    @Override
    public void onDeath(Minion killed) {
        EffectManager.drawCard(getOwner(), 1);
    }

}
