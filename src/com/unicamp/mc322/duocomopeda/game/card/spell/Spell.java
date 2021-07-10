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
    public void play() {
        Player player = getOwner();
        player.useSpellMana(this.getCost());
        this.onPlay(this);
    }

    @Override
    public void play(int cost) {
        Player player = getOwner();
        player.useSpellMana(cost);
        this.onPlay(this);
    }

    @Override
    public boolean playable(Mana mana) {
        return getCost() <= mana.getCurrentMana(true);
    }

    @Override
    public String getDetails() {
        return String.format("Card name: %s | Mana Cost: %d\nDescription: %s", getName(), getCost(), getDescription());
    }

    public void onPlay(Card playedCard) {

    }
}