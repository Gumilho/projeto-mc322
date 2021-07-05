package com.unicamp.mc322.duocomopeda.game.card.minion;

import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Vanguard extends Minion {
    
    public Vanguard(Player owner) {
        super(
            "Vanguard", 
            5, 
            5, 
            5, 
            new Trait[]{}, 
            owner
        );
    }

    @Override
    public void onPlay(Player owner, Card playedCard) {
        EffectManager.buffAllAllies(owner, 1, 1);
    }


    
}
