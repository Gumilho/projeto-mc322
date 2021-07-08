package com.unicamp.mc322.duocomopeda.game.player.deck;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.*;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.*;
import com.unicamp.mc322.duocomopeda.game.card.spell.*;

public class DemaciaDeck extends Deck {

    public DemaciaDeck(Player owner) {
        super();
        this.addCard(new Garen(owner));
        this.addCard(new Duelist(owner));
        this.addCard(new Poro(owner));
        this.addCard(new PoroDefender(owner));
        this.addCard(new Tiana(owner));
        this.addCard(new Vanguard(owner));
        this.addCard(new Judgement(owner));
        this.addCard(new RadiantStrike(owner));
        this.addCard(new RedoubledValor(owner));
        this.addCard(new SingleCombat(owner));

    }
}
