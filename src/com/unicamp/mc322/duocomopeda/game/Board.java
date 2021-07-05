package com.unicamp.mc322.duocomopeda.game;

import java.util.Arrays;
import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Board {

    public static int MAX_BENCH_SIZE = 6;
    public static int NAME_MAX_SIZE = 8;
    public static int BOARD_WIDTH = (7 + NAME_MAX_SIZE) * MAX_BENCH_SIZE + 1;

    private static Board board;    
    private Minion[] bench;
    private Minion[] battlefield;
    
    private Board() {
        this.bench = new Minion[MAX_BENCH_SIZE * 2];
        this.battlefield = new Minion[12];
    }

    public void resolveBattle() {
        Game game = Game.getInstance();
        Player attacker = game.getAttacker();
        Player defender = game.getDefender();
        for (int i = 0; i < MAX_BENCH_SIZE; i++) {
            int attackerIndex = i + MAX_BENCH_SIZE * (attacker.getIndex());
            int defenderIndex = i + MAX_BENCH_SIZE * (defender.getIndex());
            if (battlefield[attackerIndex] == null) {
                if (battlefield[defenderIndex] != null) {
                    System.out.println("Something went wrong");
                }
            } else {
                if (battlefield[defenderIndex] == null) {
                    battlefield[attackerIndex].attack(defender);    
                } else {
                    battlefield[attackerIndex].attack(battlefield[defenderIndex]);
                }
            }
        }
    }

    public ArrayList<Minion> getBench(int playerIndex) {
        ArrayList<Minion> output = new ArrayList<Minion>();
        for (int i = 0 + MAX_BENCH_SIZE * playerIndex; i < MAX_BENCH_SIZE + MAX_BENCH_SIZE * playerIndex; i++) {
            if (bench[i] != null) {
                output.add(bench[i]);
            }
        }
        return output;
    }

    public Minion getBenchCard(int playerIndex, int cardIndex) {
        //TODO: catch no minion exception
        return bench[cardIndex + MAX_BENCH_SIZE * playerIndex];
    }

    public void moveUnitToBattlefield(Minion minion, int playerIndex) {
        for (int i = 0 + MAX_BENCH_SIZE * playerIndex; i < MAX_BENCH_SIZE + MAX_BENCH_SIZE * playerIndex; i++) {
            if (bench[i] == minion) {
                bench[i] = null;
            }
        }
        int i = 0 + MAX_BENCH_SIZE * playerIndex;
        //TODO: catch IndexOutOfBoundsException
        while (battlefield[i] != null) i++;
        battlefield[i] = minion;
    }

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    private void printBench(int playerIndex) {
        
        for (int i = 0; i < MAX_BENCH_SIZE; i++) {
            Minion minion = bench[i + MAX_BENCH_SIZE * playerIndex];
            String minionName = "        ";
            if (minion != null) {
                minionName = minion.getName();
                if (minionName.length() > NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, NAME_MAX_SIZE - 3) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - minionName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        minionName += " ";
                    }
                }
            }
            System.out.print("| (" + i + ") " + minionName + " ");
        }
        System.out.println("|");
    }
    private void printBattlefield(int playerIndex) {
        for (int i = 0; i < MAX_BENCH_SIZE; i++) {
            Minion minion = battlefield[i + MAX_BENCH_SIZE * playerIndex];
            String minionName = "        ";
            if (minion != null) {
                minionName = minion.getName();
                if (minionName.length() > NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, NAME_MAX_SIZE - 3) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - minionName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        minionName += " ";
                    }
                }
            }
            System.out.print("|     " + minionName + " ");
        }
        System.out.println("|");

    }
    private void printPlayer2Board() {

        // First Line: Bench
        printBench(1);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
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
        for (int i = 0; i < BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");
        
        // Third Line: Bench
        printBench(0);

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

    public int placeUnit(Minion minion, int playerIndex) {
        for (int i = 0 + MAX_BENCH_SIZE * playerIndex; i < MAX_BENCH_SIZE + MAX_BENCH_SIZE * playerIndex; i++) {
            if (bench[i] == null) {
                bench[i] = minion;
                return i;
            }
        }
        //TODO: turn into exception
        System.out.println("the board is full");
        return -1;
    }

    public void returnUnitsToBench() {
        for (int i = 0; i < MAX_BENCH_SIZE * 2; i++) {
            bench[i] = battlefield[i];
            battlefield[i] = null;
        }
    }

    public void remove(Minion minion) {
        for (int i = 0; i < MAX_BENCH_SIZE * 2; i++) {
            if (bench[i] == minion) {
                bench[i] = null;
                return;
            }
        }
        for (int i = 0; i < MAX_BENCH_SIZE * 2; i++) {
            if (battlefield[i] == minion) {
                battlefield[i] = null;
                return;
            }
        }
    }


}