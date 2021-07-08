package com.unicamp.mc322.duocomopeda.game.player.deck;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.*;

public class PoroDeck extends Deck {

    public PoroDeck(Player owner) {
        super();
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));
        this.addCard(new Poro(owner));

    }
}
