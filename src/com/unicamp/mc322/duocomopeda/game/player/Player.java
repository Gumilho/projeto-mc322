package com.unicamp.mc322.duocomopeda.game.player;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.stats.Health;
import com.unicamp.mc322.duocomopeda.stats.Killable;
import com.unicamp.mc322.duocomopeda.stats.Mana;

public abstract class Player implements Killable {

    private Card hand;

    private Mana mana;

    private Deck deck;

    private String nickname;

    private Health health;

    public Player() {
    }

    public void act() {
        // TODO implement here
    }

    public void die() {
        // TODO implement here
    }

    private void playFromHand() {
        // TODO implement here
    }

}