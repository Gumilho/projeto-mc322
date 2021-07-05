package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Judgement extends Spell {
    
    public Judgement(Player owner) {
        super(
            "Judgement", 
            8,
            owner
        );
    }

    public void onPlay(Player owner, Card playedCard) {
        EffectManager.hitAllDefenders(owner);
    }
}
