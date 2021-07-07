package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.EffectManager;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Judgement extends Spell {

    public Judgement(Player owner) {
        super("Judgement", 8, owner, "Effect: Choose and ally to strike all enemy units");
    }

    public void onPlay(Card playedCard) {
        EffectManager.hitAllDefenders(getOwner());
    }
}
