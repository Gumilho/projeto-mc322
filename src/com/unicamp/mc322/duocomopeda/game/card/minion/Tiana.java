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
            owner,
            "Effect: When this card is played, choose one ally unit to attack the opponent's nexus"
        );
    }

    @Override
    public void onPlay(Player owner, Card playedCard) {
        EffectManager.attackNexus(owner);
    }

}
