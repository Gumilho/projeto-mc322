package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;


import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;
public class Tiana extends Minion {
    
    public Tiana(Player owner) {
        super(
            "Tiana", 
            8, 
            7, 
            7, 
            EnumSet.noneOf(Trait.class),
            owner
        );
    }

    @Override
    public void onPlay(Player owner, Card playedCard) {
        EffectManager.attackNexus(owner);
    }

}
