package com.unicamp.mc322.duocomopeda.game.player.deck;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.*;

public class PoroDefenderDeck extends Deck {

    public PoroDefenderDeck(Player owner) {
        super();
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new PoroDefender(owner));

    }
}
