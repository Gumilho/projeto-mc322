package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class RedoubledValor extends Spell {

    public RedoubledValor(Player owner) {
        super("Redoubled Valor", 6, owner, "Effect: Choose an ally; Heal it completely; Double its stats");
    }

    public void onPlay(Card playedCard) {
        EffectManager.healCompletely(getOwner());
        EffectManager.doubleStats(getOwner());
    }
}
