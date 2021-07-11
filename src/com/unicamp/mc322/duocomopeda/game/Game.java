package com.unicamp.mc322.duocomopeda.game;

import java.util.Random;
import java.util.Scanner;

import com.unicamp.mc322.duocomopeda.game.player.*;

public class Game {

    public static final int NUMBER_OF_PLAYERS = 2;

    private static Game game;

    private Player[] players;
    private Board board;
    private Scanner keyboard;
    private GamePhase gamePhase;
    private boolean confirmed;
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
        this.confirmed = false;
        this.board = Board.getInstance();
        this.keyboard = new Scanner(System.in);
        this.players = new Player[2];
        this.gamePhase = GamePhase.MAIN;
        this.graphicsEngine = TextualGraphicsEngine.getInstance();
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
    }

    public void setupTestScenario(String nickname1, String deckName1, String nickname2, String deckName2) {
        this.chooseAttacker();
        this.players = new Player[2];
        players[0] = new PlayerHuman(nickname1, keyboard, 0, attacker, deckName1);
        players[1] = new PlayerHuman(nickname2, keyboard, 1, attacker, deckName2);
        pullInitialHand(players[0]);
        pullInitialHand(players[1]);
    }

    private void chooseAttacker() {
        Random r = new Random();
        this.attacker = r.nextInt(2);
    }

    private void setupPlayers() {
        this.players = new Player[2];
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {

            enterPlayerInfo(i);
            pullInitialHand(players[i]);
            runMulligan(players[i]);
        }
        System.out.println("Player " + players[attacker] + " starts attacking.");

    }

    private void enterPlayerInfo(int playerIndex) {
        String type, name, deckName;
        System.out.print("Enter Player " + playerIndex + " type [(H)uman/(A)I]: ");
        type = keyboard.nextLine();
        System.out.print("Enter Player " + playerIndex + " nickname: ");
        name = keyboard.nextLine();
        System.out.print("Enter Player " + playerIndex + " deck name (demacia/poro/poro-defender): ");
        deckName = keyboard.nextLine();
        while (name.length() > 40) {
            System.out.print("The nickname has to be at most 40 characters, please enter again: ");
            name = keyboard.nextLine();
        }
        if (type.compareTo("H") == 0) {
            players[playerIndex] = new PlayerHuman(name, keyboard, playerIndex, attacker, deckName);
        } else if (type.compareTo("A") == 0) {
            players[playerIndex] = new PlayerAI(name, playerIndex, attacker, deckName);
        }
    }

    private void pullInitialHand(Player player) {
        player.draw(4);
    }

    private void runMulligan(Player player) {
        System.out.println("\nPlayer " + player + " Mulligan");
        graphicsEngine.printPlayerHand(player);
        System.out.print("Which card do you want to swap? (enter 4 for none): ");
        boolean[] swapList = new boolean[4];
        int input = player.getInputInt(5);
        while (input != 4) {
            swapList[input] = !swapList[input];
            System.out.print("Do you want to change another one? Press 4 if you're done: ");
            input = player.getInputInt(5);
        }
        keyboard.nextLine(); // Consume newline left-over
        for (int i = 0; i < 4; i++) {
            if (swapList[i]) {
                player.mulligan(i);
            }
        }
    }

    public void incrementPassedPlayers() {
        passedPlayers++;
    }

    public void confirmUnit() {
        confirmed = true;
    }

    public void flipTurn() {
        turnToken = 1 - turnToken; // flips the token
    }

    private void processCombatPhase() {
        // Start combat phase or end turn
        if (gamePhase == GamePhase.COMBAT) {
            confirmed = false;
            processPlayerCombatSetup();
            confirmed = false;
            flipTurn();
            processPlayerCombatSetup();
            board.resolveBattle();
            confirmed = false;
        }
    }

    private void processPlayerCombatSetup() {
        while (!confirmed) {
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
        printGameState();
        processPlayerInput();
    }

    private void processPlayerInput() {
        try {
            int pass = passedPlayers;
            players[turnToken].readInput();
            resetPassCounter(pass);
            flipTurn();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        TextualGraphicsEngine.pressEnterKeyToContinue();
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

    public void startCombat() {
        if (board.isEmpty(players[attacker])) {
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
        board.resetUnits();
        roundCounter++;
        graphicsEngine.advanceRound(roundCounter, players[this.attacker]);
    }

    private void printGameState() {
        graphicsEngine.printGameState(players, turnToken);
    }

    Player getAttacker() {
        return players[attacker];
    }

    Player getDefender() {
        return players[1 - attacker];
    }

    public Player getOpponent(Player player) {
        return players[1 - player.getIndex()];
    }

    public void declareWinner(int index) {
        System.out.println("Player " + players[1 - index] + " won the game! Congratulations!");
    }

}