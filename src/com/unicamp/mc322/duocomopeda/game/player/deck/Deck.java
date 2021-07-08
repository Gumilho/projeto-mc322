package com.unicamp.mc322.duocomopeda.game.player.deck;

import java.util.ArrayList;
import java.util.Collections;

import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<Card> discardPile;

    public Deck() {
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
        for (int i = 0; i < quantity; i++) {
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

}