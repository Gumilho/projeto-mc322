package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Vanguard extends Minion {

    public Vanguard(Player owner) {
        super("Vanguard", 5, 5, 5, EnumSet.noneOf(Trait.class), owner,
                "Effect: When this card is played, give +1/+1 to all allies");
    }

    @Override
    public void onPlay(Card playedCard) {
        EffectManager.buffAllAllies(getOwner(), 1, 1);
    }

}
