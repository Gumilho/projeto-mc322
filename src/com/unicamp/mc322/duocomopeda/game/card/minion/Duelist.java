package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Duelist extends Minion {
    
    public Duelist(Player owner) {
        super(
            "Duelist", 
            3, 
            3, 
            2, 
            EnumSet.noneOf(Trait.class),
            owner,
            "Effect: When this card kills an enemy, add a \"Poro\" from your deck to your hand"
        );
    }

    @Override
    public void onKill(Player owner, Minion killer, Minion killed) {
        EffectManager.drawSpecificCard(owner, "Poro");
    }

}
