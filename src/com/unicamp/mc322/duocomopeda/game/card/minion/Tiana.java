package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.effect.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;
public class Tiana extends Minion {
    
    public Tiana(Player owner) {
        super(
            "Tiana", 
            8, 
            7, 
            7, 
            new Trait[]{}, 
            owner
        );
    }

    @Override
    public void onPlay(Player owner, Card playedCard) {
        EffectManager.attackNexus(owner);
    }

}
