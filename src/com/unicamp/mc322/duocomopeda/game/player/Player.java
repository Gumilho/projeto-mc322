package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;
//hi
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;
import com.unicamp.mc322.duocomopeda.game.stats.Mana;

public abstract class Player implements Killable {

    public static int INITIAL_HAND_COUNT = 4;
    public static int INITIAL_HEALTH = 20;

    private ArrayList<Card> hand;

    private Mana mana;

    private Deck deck;

    private String nickname;

    private Health health;

    private boolean passed;

    public Player(String nickname) {
        this.nickname = nickname;
        this.health = new Health(INITIAL_HEALTH, this);
        this.deck = new Deck();
        this.hand = new ArrayList<Card>();
        this.hand.addAll(deck.draw(INITIAL_HAND_COUNT));
        this.mana = new Mana();
    }

    protected abstract Command getCommand();

    public void act() {
        // bom dia
        Command command = getCommand();
        switch (command) {
            case SELECT:

                break;
            case PLAY:

                break;
            case BATTLE:

                break;
            case PASS:

                break;

            default:
                break;
        }
    }

    public void die() {
    }

    private void playFromHand(Card card) {
        this.mana.spend(card.getCost());
        card.play();
    }

    public void draw(int quantity) {
        ArrayList<Card> cards = this.deck.draw(quantity);
        while (cards.size() + hand.size() > 10) {
            cards.remove(cards.size() - 1);
        }
        if (cards.size() + hand.size() > 10) {

        }
    }

    public void draw() {
        this.deck.draw(1);
    }

    public boolean getPassed() {
        return passed;
    }

    public String getNickname() {
        return nickname;
    }

    public void startRound() {
        this.draw();
    }
}