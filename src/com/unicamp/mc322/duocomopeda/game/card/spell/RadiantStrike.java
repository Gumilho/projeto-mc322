package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class RadiantStrike extends Spell {

    public RadiantStrike(Player owner) {
        super("Radiant Strike", 1, owner, "Effect: Give +1/+1 to an ally");
    }

    public void onPlay(Card playedCard) {
        EffectManager.buffSingleAlly(getOwner(), 1, 1);
    }
}
