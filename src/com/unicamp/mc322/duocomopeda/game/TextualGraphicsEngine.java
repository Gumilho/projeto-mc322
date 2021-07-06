package com.unicamp.mc322.duocomopeda.game;

import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class TextualGraphicsEngine {
    public TextualGraphicsEngine() {

    }

    private void printBench(int playerIndex) {

        for (int i = 0; i < Board.MAX_BENCH_SIZE; i++) {
            Minion minion = Board.getInstance().getBench(playerIndex)[i + Board.MAX_BENCH_SIZE * playerIndex];
            String minionName = "        ";
            String minionPower = " ";
            String minionHealth = " ";
            if (minion != null) {
                minionName = minion.getName();
                minionPower = "" + minion.getPower();
                minionHealth = "" + minion.getHealth();
                if (minionName.length() > Board.NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, Board.NAME_MAX_SIZE - 3) + "...";
                } else {
                    int numberOfWhiteSpaces = Board.NAME_MAX_SIZE - minionName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        minionName += " ";
                    }
                }
            }
            System.out.print("| (" + i + ") " + minionName + " " + minionPower + "/" + minionHealth + " ");
        }
        System.out.println("|");
    }

    private void printBattlefield(int playerIndex) {
        for (int i = 0; i < Board.MAX_BENCH_SIZE; i++) {
            Minion minion = Board.getInstance().getBattlefield()[i + Board.MAX_BENCH_SIZE * playerIndex];
            String minionName = "        ";
            String minionPower = " ";
            String minionHealth = " ";
            if (minion != null) {
                minionName = minion.getName();
                minionPower = "" + minion.getPower();
                minionHealth = "" + minion.getHealth();
                if (minionName.length() > Board.NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, Board.NAME_MAX_SIZE - 3) + "...";
                } else {
                    int numberOfWhiteSpaces = Board.NAME_MAX_SIZE - minionName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        minionName += " ";
                    }
                }
            }
            System.out.print("|     " + minionName + " " + minionPower + "/" + minionHealth + " ");
        }
        System.out.println("|");

    }

    private void printPlayer2Board() {

        // First Line: Bench
        printBench(1);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");

        // Third Line: Battlefield
        printBattlefield(1);

    }

    private void printPlayer1Board() {

        // First Line: Battlefield
        printBattlefield(0);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");

        // Third Line: Bench
        printBench(0);

    }

    public void printBoard() {

        /*****************
         * Player 2 Board *
         *****************/

        // First Line
        System.out.print("#");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        this.printPlayer2Board();

        // Middle division
        System.out.print("#");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        /*****************
         * Player 1 Board *
         *****************/

        this.printPlayer1Board();

        // Last Line
        System.out.print("#");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");
    }

}
