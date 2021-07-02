package com.unicamp.mc322.duocomopeda.game;

import java.util.Arrays;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.card.traits.Trait;
import com.unicamp.mc322.duocomopeda.game.card.effect.Effect;

public class Board {

    public static int NAME_MAX_SIZE = 8;
    public static int BOARD_WIDTH = (8 + NAME_MAX_SIZE) * 6 + 1;

    private static Board board;    
    private Card[] bench;
    private Card[] battlefield;
    
    private Board() {
        this.bench = new Card[12];
        this.battlefield = new Card[12];
        // test
        bench[4] = new Minion("DE006", "Poro", 1, 2, 1, 
            new Trait[]{},
            new Effect[]{}
        );
    }

    private void resolveBattle() {
        // TODO implement here
    }

    public void moveUnitToBattlefield(int benchIndex) {
        Card card = bench[benchIndex];
        if (card == null) {
            System.out.println("No card in index " + benchIndex);
            return;
        }
        bench[benchIndex] = null;
        int i = 0;
        while (battlefield[i] != null) i++;
        battlefield[i] = card;
    }

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    private String zfill(int i) {
        if (i < 10) {
            return "0" + i;
        } else {
            return "" + i;
        }

    }

    private void printCards(Card[] cards, int addToIndex) {

        for (int i = 0; i < 6; i++) {
            Card card = cards[i];
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
            System.out.print("| (" + zfill(i + addToIndex) + ") " + cardName + " ");
        }
        System.out.println("|");
    }

    private void printPlayer2Board() {

        // First Line: Bench
        printCards(Arrays.copyOfRange(bench, 0, 6), 0);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");

        // Third Line: Battlefield
        printCards(Arrays.copyOfRange(battlefield, 0, 6), 6);

    }

    private void printPlayer1Board() {

        // First Line: Bench
        printCards(Arrays.copyOfRange(battlefield, 6, 12), 12);
        
        // Second Line
        System.out.print("o");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");
        
        // Third Line: Player 2 Battlefield
        printCards(Arrays.copyOfRange(bench, 6, 12), 18);

    }

    public void print() {

        /*****************
        * Player 2 Board *
        *****************/

        // First Line
        System.out.print("#");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        this.printPlayer2Board();

        // Middle division
        System.out.print("#");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        
        /*****************
        * Player 1 Board *
        *****************/
        
        this.printPlayer1Board();

        // Last Line
        System.out.print("#");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");
    }


}