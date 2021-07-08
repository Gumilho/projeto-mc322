package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Decimate extends Spell {

    public Decimate(Player owner) {
        super("Decimate", 5, owner, "Effect: Deal 4 to the enemy Nexus.");
    }

    public void onPlay(Card playedCard) {
        EffectManager.attackNexus(getOwner(), 4);
    }
}