package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.Command;
import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.stats.Health;
import com.unicamp.mc322.duocomopeda.game.stats.Killable;
import com.unicamp.mc322.duocomopeda.game.stats.Mana;
import com.unicamp.mc322.duocomopeda.game.menu.*;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.Game;

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
    private int index;
    private boolean isAttacker;
    
    public Player(String nickname, int index, boolean isAttacker) {
        this.index = index;
        this.nickname = nickname;
        this.health = new Health(INITIAL_HEALTH, this);
        this.deck = new Deck(this);
        this.hand = new ArrayList<Card>();
        this.mana = new Mana();
        this.isAttacker = isAttacker;
    }

    public abstract int getInputInt(int maxInt);

    public void advanceRound() {
        isAttacker = !isAttacker;
        mana.update();
    }

    public void createDeck(String name) {
        deck.create(name);
        deck.shuffle();
    }

    public void takeDamage(int amount) {
        this.health.takeDamage(amount);
    }

    public Minion chooseUnit() {
        Board board = Board.getInstance();
        System.out.print("Select your unit: ");
        int minionIndex = this.getInputInt(Board.MAX_BENCH_SIZE);
        return board.getBenchCard(this.index, minionIndex);
    }

    public Minion chooseEnemyUnit() {
        Board board = Board.getInstance();
        System.out.print("Select the enemy unit: ");
        int minionIndex = this.getInputInt(Board.MAX_BENCH_SIZE);
        return board.getBenchCard(1 - this.index, minionIndex);
    }

    public void pullInitialHand() {
        this.hand.addAll(deck.draw(INITIAL_HAND_COUNT));
    }

    public void readInput() {
        int commandInt = getInputInt(menu.getCommandListSize());
        Command command = menu.getCommand(commandInt);
        command.execute();
    }

    public void startCombat() {
        if (isAttacker) {
            menu = new AttackerCombatMenu(this);
        } else {
            menu = new DefenderCombatMenu(this);
        }
    }

    public void startRound() {
        if (isAttacker) {
            menu = new AttackerMainMenu(this);
        } else {
            menu = new DefenderMainMenu(this);
        }
        draw(1);
    }

    public void swapCard(int index) {
        Card card = hand.remove(index);
        deck.addCard(card);
        deck.shuffle();
        draw(1);
    }

    public void die() {
        Game game = Game.getInstance();
        game.declareWinner(this.index);
        game.endGame();
    }

    public void playFromHand(int cardIndex) {
        Card card = hand.get(cardIndex);
        card.play(this, mana);
        hand.remove(card);
    }

    public void displayDetails(int cardIndex) {
        Card card = hand.get(cardIndex);
        card.displayDetails();
    }

    public void draw(int quantity) {
        ArrayList<Card> cards = this.deck.draw(quantity);
        while (cards.size() + hand.size() > 10) {
            cards.remove(cards.size() - 1);
        }
        hand.addAll(cards);
    }

    public void draw() {
        this.draw(1);
    }

    public void getFromDeck(String cardName) {
        try {
            Card card = deck.removeByName(cardName);
            hand.add(card);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pass() {
        passed = true;
    }

    public boolean getPassed() {
        return passed;
    }
    
    public int getIndex() {
        return index;
    }

    public String getNickname() {
        return nickname;
    }

    public void printMenu() {
        menu.print();
    }

    public void printHand() {

        int BOARD_WIDTH = (10 + NAME_MAX_SIZE) * hand.size() + 1;
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
            String cardCost = "  ";
            if (card != null) {
                cardName = card.getName();
                cardCost = ((card.getCost() < 10) ? "0" : "") + card.getCost();
                if (cardName.length() > NAME_MAX_SIZE) {
                    cardName = cardName.substring(0, 5) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - cardName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        cardName += " ";
                    }
                }
            }
            System.out.print("| (" + i + ") " + cardName + " " + cardCost + " ");
        }
        System.out.println("|");

        // Top border
        System.out.print("#");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

    }

    @Override
    public String toString() {
        return index + " - " + nickname;
    }

    public void printInfo() {
        System.out.print(String.format("Player %d - %s %s\nHealth: %d/%d | Mana: %d/%d | SpellMana: %d/%d\n", 
            index, nickname, (isAttacker) ? "ATTACKER" : "",
            health.getCurrentHealth(), health.getMaxHealth(), 
            mana.getCurrentMana(), mana.getMaxMana(),
            mana.getCurrentSpellMana(), mana.getMaxSpellMana())
        );
    }

    public int getHandSize() {
        return hand.size();
    }
}