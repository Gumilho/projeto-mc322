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
import com.unicamp.mc322.duocomopeda.game.player.deck.*;

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

    public Player(String nickname, int index, boolean isAttacker, String deckName) {
        this.index = index;
        this.nickname = nickname;
        this.health = new Health(INITIAL_HEALTH, this);
        this.deck = createDeck(deckName);
        this.hand = new ArrayList<Card>();
        this.mana = new Mana();
        this.isAttacker = isAttacker;
    }

    // maybe change this to an int list, so we can work with non ordered numbers
    public abstract int getInputInt(ArrayList<Integer> labels);

    public int getInputInt(int maxInt) {
        ArrayList<Integer> choices = new ArrayList<Integer>();
        for (int i = 0; i < maxInt; i++) {
            choices.add(i);
        }
        return getInputInt(choices);
    }

    public Menu getMenu() {
        return menu;
    }

    public void advanceRound() {
        isAttacker = !isAttacker;
        mana.update();
    }

    private Deck createDeck(String name) {
        Deck newDeck;
        switch (name) {
            case "demacia":
                newDeck = new DemaciaDeck(this);
                break;
            case "poro":
                newDeck = new PoroDeck(this);
                break;
            case "poro-defender":
                newDeck = new PoroDefenderDeck(this);
                break;
            default:
                throw new IllegalArgumentException("No such deck, restart the game");
        }
        newDeck.shuffle();
        return newDeck;
    }

    public void takeDamage(int amount) {
        this.health.takeDamage(amount);
    }

    public Minion chooseUnit() {
        Board board = Board.getInstance();
        Game game = Game.getInstance();
        System.out.print("Whose board do you want to choose from (1 for player 1 / 2 for player 2): ");
        int playerIndex = this.getInputInt(3);
        if (playerIndex == 0) {
            throw new IllegalArgumentException("No such player!");
        }
        System.out.print("Select your unit: ");
        int minionIndex = this.getInputInt(Board.MAX_BENCH_SIZE);
        if (playerIndex == index) {
            return board.getBenchCard(this, minionIndex);
        } else {
            return board.getBenchCard(game.getOpponent(this), minionIndex);
        }

    }

    public Minion chooseAllyUnit() {
        Board board = Board.getInstance();
        System.out.print("Select your unit: ");
        int minionIndex = this.getInputInt(Board.MAX_BENCH_SIZE);
        return board.getBenchCard(this, minionIndex);
    }

    public Minion chooseEnemyUnit() {
        Board board = Board.getInstance();
        Game game = Game.getInstance();
        System.out.print("Select the enemy unit: ");
        int minionIndex = this.getInputInt(Board.MAX_BENCH_SIZE);
        return board.getBenchCard(game.getOpponent(this), minionIndex);
    }

    public void pullInitialHand() {
        this.hand.addAll(deck.draw(INITIAL_HAND_COUNT));
    }

    public void readInput() {
        int commandInt = getInputInt(menu.getLabels());
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
        card.play(mana);
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

    public Mana getMana() {
        return mana;
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

    public boolean getIsAttacker() {
        return isAttacker;
    }

    public int getCurrentHealth() {
        return health.getCurrentHealth();
    }

    public int getMaxHealth() {
        return health.getCurrentHealth();
    }

    public int getCurrentMana() {
        return mana.getCurrentMana();
    }

    public int getMaxMana() {
        return mana.getMaxMana();
    }

    public int getCurrentSpellMana() {
        return mana.getCurrentSpellMana();
    }

    public int getMaxSpellMana() {
        return mana.getMaxSpellMana();
    }

    @Override
    public String toString() {
        return index + " - " + nickname;
    }

    public int getHandSize() {
        return hand.size();
    }

    public Card getHandCard(int i) {
        return hand.get(i);
    }
}