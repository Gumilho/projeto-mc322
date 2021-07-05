package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;


public class RedoubledValor extends Spell {
    
    public RedoubledValor(Player owner) {
        super(
            "Redoubled Valor", 
            6,
            owner
        );
    }

    public void onPlay(Player owner, Card playedCard) {
        EffectManager.healCompletely(owner);
        EffectManager.doubleStats(owner);
    }
}
