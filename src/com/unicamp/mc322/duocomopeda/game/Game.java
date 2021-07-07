package com.unicamp.mc322.duocomopeda.game;

import java.util.Random;
import java.util.Scanner;

import com.unicamp.mc322.duocomopeda.game.player.*;
import com.unicamp.mc322.duocomopeda.utils.Utils;

public class Game {

    private static Game game;

    private Player[] players;
    private Board board;
    private Scanner keyboard;
    private Player currentPlayer;
    private GamePhase gamePhase;
    private TextualGraphicsEngine graphicsEngine;

    private int turnToken;
    private int passedPlayers;
    private int roundCounter;
    private int attacker;
    private boolean gameEnd;

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private Game() {
        this.gameEnd = false;
        this.passedPlayers = 0;
        this.roundCounter = 1;
        this.board = Board.getInstance();
        this.keyboard = new Scanner(System.in);
        this.players = new Player[2];
        this.gamePhase = GamePhase.MAIN;
        this.graphicsEngine = new TextualGraphicsEngine();
    }

    // Main Loop
    public void startGame() {

        this.runGameLoop();
    }

    private void runGameLoop() {
        while (!gameEnd) {
            startRound();
            // manages turn states
            while (shouldStayInMainPhase()) {
                processMainPhaseState();
            }

            // break game loop if game ended during turn state
            if (gameEnd) {
                continue;
            }

            processCombatPhase();
            printGameState();
            advanceRound();

        }
    }

    public void setup() {
        this.chooseAttacker();
        this.setupPlayers();
        this.setupDecks();
        this.setupPlayersHands();
    }

    public void setupTestScenario(String nickname1, String deckName1, String nickname2, String deckName2) {
        this.chooseAttacker();
        this.players = new Player[2];
        players[0] = new PlayerHuman(nickname1, keyboard, 0, attacker);
        players[1] = new PlayerHuman(nickname2, keyboard, 1, attacker);
        this.setupDecks(deckName1, deckName2);
        players[0].pullInitialHand();
        players[1].pullInitialHand();
    }

    private void setupPlayersHands() {

        players[0].pullInitialHand();
        players[1].pullInitialHand();
        runMulligan(players[0]);
        runMulligan(players[1]);
    }

    private void chooseAttacker() {

        Random r = new Random();
        this.attacker = r.nextInt(2);

    }

    private void setupPlayers() {

        enterPlayerInfo(0);
        enterPlayerInfo(1);

    }

    private void enterPlayerInfo(int playerIndex) {
        String type, name;
        System.out.print("Enter Player " + playerIndex + " type [(H)uman/(A)I]: ");
        type = keyboard.nextLine();
        System.out.print("Enter Player " + playerIndex + " nickname: ");
        name = keyboard.nextLine();
        while (name.length() > 40) {
            System.out.print("The nickname has to be at most 40 characters, please enter again: ");
            name = keyboard.nextLine();
        }
        if (type.compareTo("H") == 0) {
            players[playerIndex] = new PlayerHuman(name, keyboard, playerIndex, attacker);
        } else if (type.compareTo("A") == 0) {
            players[playerIndex] = new PlayerAI(name, playerIndex, attacker);
        }
        System.out.println("Player " + players[attacker] + " starts attacking.");

    }

    private void setupDecks() {
        players[0].createDeck("demacia");
        players[1].createDeck("demacia");
    }

    private void setupDecks(String deckName1, String deckName2) {
        players[0].createDeck(deckName1);
        players[1].createDeck(deckName2);
    }

    private void runMulligan(Player player) {
        System.out.println("\nPlayer " + player + " Mulligan");
        player.printHand();
        System.out.print("Which card do you want to swap? (enter 4 for none): ");
        boolean[] swapList = new boolean[4];
        int input = player.getInputInt(5);
        while (input != 4) {
            swapList[input] = !swapList[input];
            System.out.print("Do you want to change another one? Press 4 if you're done: ");
            input = player.getInputInt(5);
        }
        for (int i = 0; i < 4; i++) {
            if (swapList[i]) {
                player.swapCard(i);
            }
        }
    }

    public void incrementPassedPlayers() {
        passedPlayers++;
    }

    private void flipTurn() {
        turnToken = 1 - turnToken; // flips the token
    }

    private void processCombatPhase() {
        // Start combat phase or end turn
        if (gamePhase == GamePhase.COMBAT) {
            passedPlayers = 0;
            // Confirming unit works the same way as passing, so we're reusing the
            // passedPlayers attribute
            processPlayerCombatSetup(1);
            flipTurn();
            currentPlayer = players[turnToken];
            processPlayerCombatSetup(2);
            board.resolveBattle();
        }
    }

    private void processPlayerCombatSetup(int player) {
        while (passedPlayers < player) {
            printGameState();
            try {
                players[turnToken].readInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean shouldStayInMainPhase() {
        return roundIsActive() && gamePhase == GamePhase.MAIN && !gameEnd;
    }

    private void processMainPhaseState() {
        currentPlayer = players[turnToken];
        printGameState();
        processPlayerInput();
    }

    private void processPlayerInput() {
        try {
            int pass = passedPlayers;
            currentPlayer.readInput();
            resetPassCounter(pass);
            flipTurn();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean roundIsActive() {
        return passedPlayers < 2;
    }

    private void resetPassCounter(int pass) {
        // Process pass counts
        if (pass == passedPlayers) {
            passedPlayers = 0;
        }
    }

    public void endGame() {
        gameEnd = true;
        keyboard.close();
    }

    public void playFromHand(int cardIndex) {
        currentPlayer.playFromHand(cardIndex);
    }

    public void displayDetails(int cardIndex) {
        this.flipTurn();
        currentPlayer.displayDetails(cardIndex);
    }

    public void startCombat() {
        if (board.isEmpty(attacker)) {
            throw new IllegalArgumentException("No available units for attack");
        }
        this.flipTurn();
        gamePhase = GamePhase.COMBAT;
        players[0].startCombat();
        players[1].startCombat();
    }

    private void startRound() {
        gamePhase = GamePhase.MAIN;
        players[0].startRound();
        players[1].startRound();
        turnToken = attacker;
        passedPlayers = 0;
    }

    private void advanceRound() {
        this.attacker = 1 - this.attacker;
        players[0].advanceRound();
        players[1].advanceRound();
        board.returnUnitsToBench();
        roundCounter++;
        System.out.print("\n\n");
        System.out.println("ROUND " + String.format("%d", roundCounter));
        System.out.println("Player " + players[this.attacker] + " is attacking now.\n");
        Utils.pressEnterKeyToContinue();
    }

    // TODO: delegate functionality to TextualGraphicsEngine
    private void printGameState() {
        Utils.clearScreen();
        players[1].printInfo();
        if (turnToken == 0) {
            System.out.print("\n\n\n");
            graphicsEngine.printBoard();
            currentPlayer.printHand();
        } else if (turnToken == 1) {
            currentPlayer.printHand();
            graphicsEngine.printBoard();
            System.out.print("\n\n\n");
        }
        players[0].printInfo();

        currentPlayer.printMenu();
    }

    Player getAttacker() {
        return players[attacker];
    }

    Player getDefender() {
        return players[1 - attacker];
    }

    public void declareWinner(int index) {
        System.out.println("Player " + players[1 - index] + " won the game! Congratulations!");
    }

}