package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class FlashFreeze extends Spell {

    public FlashFreeze(Player owner) {
        super("Flash Freeze", 3, owner, "Effect: Reduce an enemy's attack to 0");
    }

    public void onPlay(Card playedCard) {
        EffectManager.zeroPower(getOwner());
    }
}
