package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;


public class SingleCombat extends Spell {
    
    public SingleCombat(Player owner) {
        super(
            "Single Combat", 
            2,
            owner
        );
    }

    public void onPlay(Player owner, Card playedCard) {
        EffectManager.duel(owner);
    }

}
