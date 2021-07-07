package com.unicamp.mc322.duocomopeda.game.card.spell;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.event.handler.SpellEventHandler;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.stats.Mana;

public abstract class Spell extends Card implements SpellEventHandler {

    public Spell(String name, int cost, Player owner, String description) {
        super(name, cost, owner, description);
    }

    @Override
    public void play(Mana mana) {
        try {
            mana.spend(this.getCost(), true);
            this.onPlay(this);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public void displayDetails() {
        System.out.println(String.format("Card name: %s | Mana Cost: %d\nDescription: %s", getName(), getCost(),
                getDescription()));
    }

    public void onPlay(Card playedCard) {

    }
}