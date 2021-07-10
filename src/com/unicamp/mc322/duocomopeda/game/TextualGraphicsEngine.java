package com.unicamp.mc322.duocomopeda.game;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.menu.Menu;
import com.unicamp.mc322.duocomopeda.game.menu.command.Command;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class TextualGraphicsEngine {

    public static final int MAX_BENCH_SIZE = 6;
    public static final int NAME_MAX_SIZE = 8;
    public static final int BOARD_WIDTH = (11 + NAME_MAX_SIZE) * MAX_BENCH_SIZE + 1;

    private static TextualGraphicsEngine textualGraphicsEngine;

    private TextualGraphicsEngine() {

    }

    public static TextualGraphicsEngine getInstance() {
        if (textualGraphicsEngine == null) {
            textualGraphicsEngine = new TextualGraphicsEngine();
        }
        return textualGraphicsEngine;
    }

    public void printCardDetails(Card card) {
        System.out.println(card.getDetails());
        pressEnterKeyToContinue();
    }

    private void printBench(Player player) {

        for (int i = 0; i < Board.MAX_BENCH_SIZE; i++) {
            Minion minion = Board.getInstance().getBench()[i + Board.MAX_BENCH_SIZE * player.getIndex()];
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

    private void printBattlefield(Player player) {
        for (int i = 0; i < Board.MAX_BENCH_SIZE; i++) {
            Minion minion = Board.getInstance().getBattlefield()[i + Board.MAX_BENCH_SIZE * player.getIndex()];
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

    private void printPlayer2Board(Player player) {

        // First Line: Bench
        printBench(player);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");

        // Third Line: Battlefield
        printBattlefield(player);

    }

    private void printPlayer1Board(Player player) {

        // First Line: Battlefield
        printBattlefield(player);

        // Second Line
        System.out.print("o");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("-");
        }
        System.out.println("o");

        // Third Line: Bench
        printBench(player);

    }

    public void printBoard(Player[] players) {

        /*****************
         * Player 2 Board *
         *****************/

        // First Line
        System.out.print("#");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        this.printPlayer2Board(players[1]);

        // Middle division
        System.out.print("#");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        /*****************
         * Player 1 Board *
         *****************/

        this.printPlayer1Board(players[0]);

        // Last Line
        System.out.print("#");
        for (int i = 0; i < Board.BOARD_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");
    }

    private void printPlayerInfo(Player player) {

        System.out.print(String.format("Player %d - %s %s\nHealth: %d/%d | Mana: %d/%d | SpellMana: %d/%d\n",
                player.getIndex(), player.getNickname(), (player.getIsAttacker()) ? "ATTACKER" : "",
                player.getCurrentHealth(), player.getMaxHealth(), player.getCurrentMana(), player.getMaxMana(),
                player.getCurrentSpellMana(), player.getMaxSpellMana()));
    }

    public void printPlayerHand(Player player) {
        int HAND_FRAME_WIDTH = (12 + NAME_MAX_SIZE) * player.getHandSize() + 1;
        // Top border
        System.out.print("#");
        for (int i = 0; i < HAND_FRAME_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

        // Count width
        for (int i = 0; i < player.getHandSize(); i++) {
            Card card = player.getHandCard(i);
            String cardName = "        ";
            String cardCost = "  ";
            String playable = "   ";
            if (card != null) {
                cardName = card.getName();
                cardCost = ((card.getCost() < 10) ? "0" : "") + card.getCost();
                playable = (card.playable(player.getMana()) ? " * " : "   ");
                if (cardName.length() > NAME_MAX_SIZE) {
                    cardName = cardName.substring(0, 5) + "...";
                } else {
                    int numberOfWhiteSpaces = NAME_MAX_SIZE - cardName.length();
                    for (int j = 0; j < numberOfWhiteSpaces; j++) {
                        cardName += " ";
                    }
                }
            }
            System.out.print("| (" + i + ")" + playable + cardName + " " + cardCost + " ");
        }
        System.out.println("|");

        // Top border
        System.out.print("#");
        for (int i = 0; i < HAND_FRAME_WIDTH - 2; i++) {
            System.out.print("=");
        }
        System.out.println("#");

    }

    public void printPlayerMenu(Player player) {
        Menu menu = player.getMenu();
        printMenuHeader(menu);
        printMenuOptions(menu);
        System.out.print("Choose one of the options (type the associated number and press enter): ");

    }

    public void printGameState(Player[] players, int turnToken) {
        clearScreen();
        printPlayerInfo(players[1]);
        if (turnToken == 0) {
            System.out.print("\n\n\n");
            printBoard(players);
            printPlayerHand(players[turnToken]);
        } else if (turnToken == 1) {
            printPlayerHand(players[turnToken]);
            printBoard(players);
            System.out.print("\n\n\n");
        }
        printPlayerInfo(players[0]);
        printPlayerMenu(players[turnToken]);
    }

    private void printMenuHeader(Menu menu) {
        String name = menu.getName();
        System.out.println();
        for (int i = 0; i < name.length() + 4; i++) {
            System.out.print("#");
        }
        System.out.println();

        System.out.print("# ");
        System.out.print(name);
        System.out.println(" #");

        for (int i = 0; i < name.length() + 4; i++) {
            System.out.print("#");
        }
        System.out.println();

    }

    private void printMenuOptions(Menu menu) {
        for (Command command : menu.getCommandList()) {
            System.out.print(command.getLabel());
            System.out.print(" - ");
            System.out.println(command.getName());
        }
    }

    public void advanceRound(int roundCounter, Player attacker) {
        System.out.print("\n\n");
        System.out.println("ROUND " + String.format("%d", roundCounter));
        System.out.println("Player " + attacker + " is attacking now.\n");
        pressEnterKeyToContinue();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterKeyToContinue() {
        System.out.print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
