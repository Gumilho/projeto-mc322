package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.event.handler.SpellEventHandler;
import com.unicamp.mc322.duocomopeda.game.player.Player;
public abstract class Spell extends Card implements SpellEventHandler{

    public Spell(String name, int cost, Player owner) {
        super(name, cost, owner);
    }

    public void play(Player owner) {
        this.onPlay(owner, this);
    }

    public void onPlay(Player owner, Card playedCard) {

    }
}