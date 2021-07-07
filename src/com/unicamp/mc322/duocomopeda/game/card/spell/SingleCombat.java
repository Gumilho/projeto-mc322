package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class SingleCombat extends Spell {

    public SingleCombat(Player owner) {
        super("Single Combat", 2, owner, "Choose an ally and an oppponent for a instant combat");
    }

    public void onPlay(Card playedCard) {
        EffectManager.duel(owner);
    }

}
