package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;
import java.util.Collections;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.*;
import com.unicamp.mc322.duocomopeda.game.card.minion.champion.*;
import com.unicamp.mc322.duocomopeda.game.card.spell.*;

public class Deck {

    private Player owner;
    private ArrayList<Card> cards;
    private ArrayList<Card> discardPile;

    public Deck(Player owner) {
        this.owner = owner;
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> draw() {
        return this.draw(1);
    }

    public ArrayList<Card> draw(int quantity) {
        ArrayList<Card> output = new ArrayList<Card>();
        for (int i=0; i < quantity; i++) {
            if (!cards.isEmpty()) {
                output.add(cards.remove(0));
            }
        }
        return output;
    }

    public void discard(Card card) {
        discardPile.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeByName(String cardName) {
        for (Card card : cards) {
            if (card.getName() == cardName) {
                cards.remove(card);
                return card;
            }
        }
        throw new IndexOutOfBoundsException("No card named " + cardName + " in deck");
    }

    public void create(String name) {
        switch (name) {
            case "poro-defender":
            
                this.addCard(new PoroDefender(owner));
                this.addCard(new PoroDefender(owner));
                this.addCard(new PoroDefender(owner));
                this.addCard(new PoroDefender(owner));
                this.addCard(new PoroDefender(owner));
                this.addCard(new PoroDefender(owner));
                this.addCard(new PoroDefender(owner));
                break;
            case "poro":
                this.addCard(new Poro(owner));
                this.addCard(new Poro(owner));
                this.addCard(new Poro(owner));
                this.addCard(new Poro(owner));
                this.addCard(new Poro(owner));
                break;
            case "demacia":
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
                break;

            default:
                System.out.println("Deck not found");
                break;
        }
    }

}