package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;


public class RadiantStrike extends Spell {
    
    public RadiantStrike(Player owner) {
        super(
            "Radiant Strike", 
            1,
            owner
        );
    }

    public void onPlay(Player owner, Card playedCard) {
        EffectManager.buffSingleAlly(owner, 1, 1);
    }
}
