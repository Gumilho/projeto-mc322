package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;
import java.util.Collections;

import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Deck {

    private ArrayList<Card> cards;

    private ArrayList<Card> discardPile;

    public Deck() {
        this.cards = new ArrayList<Card>();
        // Making Deck here
        // cards.add()
    }

    public ArrayList<Card> draw() {
        ArrayList<Card> output = new ArrayList<Card>();
        output.add(cards.remove(0));
        return output;
    }
    public ArrayList<Card> draw(int quantity) {
        ArrayList<Card> output = new ArrayList<Card>();
        for (int i=0; i < quantity; i++){
            output.add(cards.remove(0));
        }
        
        return output;
    }

    public void discard(Card card) {
        discardPile.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}