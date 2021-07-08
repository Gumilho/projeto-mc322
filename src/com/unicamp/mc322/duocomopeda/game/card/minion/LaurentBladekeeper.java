package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class LaurentBladekeeper extends Minion {

    public LaurentBladekeeper(Player owner) {
        super("Laurent Bladekeeper", 4, 3, 3, EnumSet.noneOf(Trait.class), owner, "Play: Grant an ally +2/+2");
    }

    @Override
    public void onPlay(Card playedCard) {
        EffectManager.buffSingleAlly(getOwner(), 2, 2);
        super.onPlay(playedCard);
    }
}