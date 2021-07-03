package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.Command;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;
import com.unicamp.mc322.duocomopeda.game.stats.Mana;
import com.unicamp.mc322.duocomopeda.game.menu.CombatMenu;
import com.unicamp.mc322.duocomopeda.game.menu.MainMenu;
import com.unicamp.mc322.duocomopeda.game.menu.Menu;

public abstract class Player implements Killable {

    public static int INITIAL_HAND_COUNT = 4;
    public static int INITIAL_HEALTH = 20;
    public static int NAME_MAX_SIZE = 8;

    private ArrayList<Card> hand;
    private Mana mana;
    private Deck deck;
    private String nickname;
    private Health health;
    private Menu menu;
    private boolean passed;
    
    public Player(String nickname) {
        this.nickname = nickname;
        this.health = new Health(INITIAL_HEALTH, this);
        this.deck = new Deck();
        this.hand = new ArrayList<Card>();
        this.mana = new Mana();
    }

    public abstract int getInputInt(int maxInt);

    public void pullInitialHand() {
        this.hand.addAll(deck.draw(INITIAL_HAND_COUNT));
    }
    public void readInput() {
        int commandInt = getInputInt(menu.getCommandListSize());
        Command command = menu.getCommand(commandInt);
        command.getInput(this);
        command.execute(this);
    }

    public void startCombat() {
        menu = new CombatMenu();
    }

    public void startRound(boolean isAttacker) {
        menu = new MainMenu(isAttacker);
    }

    public void printMenu() {
        menu.print();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void swapCard(int index) {
        Card card = hand.remove(index);
        deck.addCard(card);
        deck.shuffle();
        draw(1);
    }

    public void die() {
    }

    public void playFromHand(int cardIndex) {
        Card card = hand.remove(cardIndex);
        this.mana.spend(card.getCost());
        card.play();
    }

    public void draw(int quantity) {
        ArrayList<Card> cards = this.deck.draw(quantity);
        while (cards.size() + hand.size() > 10) {
            cards.remove(cards.size() - 1);
        }
        hand.addAll(cards);
    }

    public void draw() {
        this.deck.draw(1);
    }

    public void pass() {
        passed = true;
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

    public void printHand() {

        int BOARD_WIDTH = (7 + NAME_MAX_SIZE) * hand.size() + 1;
        // Top border
        System.out.print("#");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        // Count width
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            String cardName = "        ";
            if (card != null) {
                cardName = card.getName();
                if (cardName.length() > NAME_MAX_SIZE) {
                    cardName = cardName.substring(0, 5) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - cardName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        cardName += " ";
                    }
                }
            }
            System.out.print("| (" + i + ") " + cardName + " ");
        }
        System.out.println("|");

        // Top border
        System.out.print("#");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");


    }

}