package com.unicamp.mc322.duocomopeda.game.player;

import java.util.*;

/**
 * 
 */
public abstract class Player implements Killable {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private Card hand;

    /**
     * 
     */
    private Mana mana;

    /**
     * 
     */
    private Deck deck;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    public Health health;








    /**
     * 
     */
    public void act() {
        // TODO implement here
    }

    /**
     * 
     */
    public void die() {
        // TODO implement here
    }

    /**
     * 
     */
    private void playFromHand() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Die() {
        // TODO implement here
    }

}