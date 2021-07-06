package com.unicamp.mc322.duocomopeda.game;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Board {

    public static int MAX_BENCH_SIZE = 6;
    public static int NAME_MAX_SIZE = 8;
    public static int BOARD_WIDTH = (11 + NAME_MAX_SIZE) * MAX_BENCH_SIZE + 1;

    private static Board board;    
    private Minion[] bench;
    private Minion[] battlefield;
    
    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

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
                    throw new IllegalArgumentException("An unexpected error occured");
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

    public boolean isEmpty(int attacker) {
        boolean isEmpty = true;
        for (int i = 0 + MAX_BENCH_SIZE * attacker; i < MAX_BENCH_SIZE + MAX_BENCH_SIZE * attacker; i++) {
            if (bench[i] != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
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
        Minion minion = bench[cardIndex + MAX_BENCH_SIZE * playerIndex];
        if (minion == null) {
            throw new IllegalArgumentException("No minion in this slot");
        }
        return minion;
    }

    private void removeFromBench(Minion minion) {
        for (int i = 0; i < MAX_BENCH_SIZE * 2; i++) {
            if (bench[i] == minion) {
                bench[i] = null;
            }
        }
        throw new IllegalArgumentException("Did not find minion");
    }
    
    public void moveAttackerUnitToBattlefield(Minion minion, int playerIndex, int battlefieldPosition) {
        if (battlefield[playerIndex * 6 + battlefieldPosition] != null) {
            throw new IllegalArgumentException("This position is not empty");
        } else {
            removeFromBench(minion);
            battlefield[playerIndex * 6 + battlefieldPosition] = minion;
        }
    }

    public void moveDefenderUnitToBattlefield(Minion minion, int playerIndex, int battlefieldPosition) {
        
        Minion enemy = battlefield[(1 - playerIndex) * 6 + battlefieldPosition];
        if (enemy == null) {
            throw new IllegalArgumentException("No attacker in this position");
        } else if (enemy.isElusive()) {
            if (!minion.isElusive()) {
                throw new IllegalArgumentException("Can't block elusive units");
            }
        }
        if (battlefield[playerIndex * 6 + battlefieldPosition] != null) {
            throw new IllegalArgumentException("This position is not empty");
        } else {
            removeFromBench(minion);
            battlefield[playerIndex * 6 + battlefieldPosition] = minion;
        }
    }

    private void printBench(int playerIndex) {
        
        for (int i = 0; i < MAX_BENCH_SIZE; i++) {
            Minion minion = bench[i + MAX_BENCH_SIZE * playerIndex];
            String minionName = "        ";
            String minionPower = " ";
            String minionHealth = " ";
            if (minion != null) {
                minionName = minion.getName();
                minionPower = "" + minion.getPower();
                minionHealth = "" + minion.getHealth();
                if (minionName.length() > NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, NAME_MAX_SIZE - 3) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - minionName.length();
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
        for (int i = 0; i < MAX_BENCH_SIZE; i++) {
            Minion minion = battlefield[i + MAX_BENCH_SIZE * playerIndex];
            String minionName = "        ";
            String minionPower = " ";
            String minionHealth = " ";
            if (minion != null) {
                minionName = minion.getName();
                minionPower = "" + minion.getPower();
                minionHealth = "" + minion.getHealth();
                if (minionName.length() > NAME_MAX_SIZE) {
                    minionName = minionName.substring(0, NAME_MAX_SIZE - 3) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - minionName.length();
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
        throw new IllegalArgumentException("the board is full");
    }

    public void returnUnitsToBench() {
        for (int playerIndex = 0; playerIndex < 2; playerIndex++){
            for (int i = MAX_BENCH_SIZE * playerIndex; i < MAX_BENCH_SIZE * (1 + playerIndex); i++) {
                int j = i;
                while (j < MAX_BENCH_SIZE * (1 + playerIndex) && bench[j] != null) {
                    j++;
                }
                if (j >= MAX_BENCH_SIZE * (1 + playerIndex)) {
                    System.out.println("Bench is full");

                } else {
                    bench[j] = battlefield[i];
                }
                battlefield[i] = null;
            }
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