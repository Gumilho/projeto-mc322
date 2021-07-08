package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class BrightsteelProtector extends Minion {

    public BrightsteelProtector(Player owner) {
        super("Brightsteel Protector", 2, 3, 2, EnumSet.noneOf(Trait.class), owner,
                "Play: Give an ally Barrier this round");
    }

    @Override
    public void onPlay(Card playedCard) {
        EffectManager.addBarrier(getOwner());
        super.onPlay(playedCard);
    }
}