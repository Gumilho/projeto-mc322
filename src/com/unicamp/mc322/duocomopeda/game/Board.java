package com.unicamp.mc322.duocomopeda.game;

import java.util.Arrays;

import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class Board {

    public static int NAME_MAX_SIZE = 8;
    public static int BOARD_WIDTH = (8 + NAME_MAX_SIZE) * 6 + 1;

    private static Board board;    
    private Minion[] bench;
    private Minion[] battlefield;
    
    private Board() {
        this.bench = new Minion[12];
        this.battlefield = new Minion[12];
    }

    public void resolveBattle() {
        Game game = Game.getInstance();
        int attacker = game.getAttacker();
        for (int i = 0; i < 6; i++) {
            int attackerIndex = i + 6 * (1 - attacker);
            int defenderIndex = i + 6 * (attacker);
            battlefield[attackerIndex].attack(battlefield[defenderIndex]);
        }
    }

    public void moveUnitToBattlefield(int benchIndex) {
        Minion minion = bench[benchIndex];
        if (minion == null) {
            System.out.println("No card in index " + benchIndex);
            return;
        }
        bench[benchIndex] = null;
        int i = 0;
        while (battlefield[i] != null) i++;
        battlefield[i] = minion;
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

    private void printMinions(Minion[] minions, int addToIndex) {

        for (int i = 0; i < 6; i++) {
            Minion minion = minions[i];
            String minionName = "        ";
            if (minion != null) {
                minionName = minion.getName();
                if (minionName.length() > NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, 5) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - minionName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        minionName += " ";
                    }
                }
            }
            System.out.print("| (" + zfill(i + addToIndex) + ") " + minionName + " ");
        }
        System.out.println("|");
    }

    private void printPlayer2Board() {

        // First Line: Bench
        printMinions(Arrays.copyOfRange(bench, 0, 6), 0);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");

        // Third Line: Battlefield
        printMinions(Arrays.copyOfRange(battlefield, 0, 6), 6);

    }

    private void printPlayer1Board() {

        // First Line: Bench
        printMinions(Arrays.copyOfRange(battlefield, 6, 12), 12);
        
        // Second Line
        System.out.print("o");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");
        
        // Third Line: Player 2 Battlefield
        printMinions(Arrays.copyOfRange(bench, 6, 12), 18);

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