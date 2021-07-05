package com.unicamp.mc322.duocomopeda.game;

import java.util.Random;
import java.util.Scanner;

import com.unicamp.mc322.duocomopeda.game.player.*;
import com.unicamp.mc322.duocomopeda.utils.Utils;
import com.unicamp.mc322.duocomopeda.game.card.minion.Poro;

public class Game {

    private static Game game;

    private Player[] players;
    private Board board;
    private Scanner keyboard;
    private Player currentPlayer;
    private GamePhase gamePhase;
    
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
    }

    public void setup() {
        this.setupPlayers();
        this.chooseAttacker();
        this.setupDecks();
        players[0].pullInitialHand();
        players[1].pullInitialHand();
        runMulligan(players[0]);
        runMulligan(players[1]);
    }

    public void setup(String nickname1, String deckName1, String nickname2, String deckName2) {
        this.players = new Player[2];
        players[0] = new PlayerHuman(nickname1, keyboard, 0);
        players[1] = new PlayerHuman(nickname2, keyboard, 1);
        this.chooseAttacker();
        this.setupDecks(deckName1, deckName2);
        players[0].pullInitialHand();
        players[1].pullInitialHand();
        runMulligan(players[0]);
        runMulligan(players[1]);
    }

    private void chooseAttacker() {

        Random r = new Random();
        this.attacker = r.nextInt(2);
        System.out.println("Player " + players[attacker] + " starts attacking.");
        
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
            players[playerIndex] = new PlayerHuman(name, keyboard, playerIndex);
        } else if (type.compareTo("A") == 0) {
            players[playerIndex] = new PlayerAI(name, playerIndex);
        }

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
    // Main Loop
    public void startGame() {

        while(!gameEnd) {
            startRound();
            int turnToken = attacker;
            while(passedPlayers < 2 && gamePhase == GamePhase.MAIN && !gameEnd) {
                int pass = passedPlayers;
                currentPlayer = players[turnToken];
                print(turnToken);
                currentPlayer.readInput();
                
                // Process pass counts
                if (pass == passedPlayers) {
                    passedPlayers = 0;
                }
                
                turnToken = 1 - turnToken; // flips the token
            }
            if (!gameEnd) {
                // Start combat phase or end turn
                if (gamePhase == GamePhase.COMBAT) {
                    turnToken = 1 - turnToken; // flips the token back to the attacker
                    passedPlayers = 0;
                    // Confirming unit works the same way as passing, so we're reusing the passedPlayers attribute
                    while (passedPlayers < 1) {
                        print(turnToken);
                        players[turnToken].readInput();
                    }
                    turnToken = 1 - turnToken; // flips the token to the defender
                    while (passedPlayers < 2) {
                        print(turnToken);
                        players[turnToken].readInput();
                    }
                    board.resolveBattle();
                }

                advanceRound();
                Utils.pressEnterKeyToContinue();
                
            }
        }
    }

    public void endGame() {
        gameEnd = true;
    }

    public void playFromHand(int cardIndex) {
        currentPlayer.playFromHand(cardIndex);
    }

    public void startCombat() {
        gamePhase = GamePhase.COMBAT;
        players[0].startCombat();
        players[1].startCombat();
    }


    private void startRound() {
        players[0].startRound(attacker == 0);
        players[1].startRound(attacker == 1);
    }

    private void advanceRound() {
        attacker = 1 - attacker;
        board.returnUnitsToBench();
        System.out.print("\n\n");
        System.out.println("ROUND " + String.format("%d", roundCounter + 1));
        System.out.println("Player " + players[attacker].getNickname() + " is attacking now.\n");
    }

    private void print(int turnToken) {
        Utils.clearScreen();
        if (turnToken == 0) {
            System.out.print("\n\n\n");
            board.print();
            currentPlayer.printHand();
        } else if (turnToken == 1) {
            currentPlayer.printHand();
            board.print();
            System.out.print("\n\n\n");
        }
        currentPlayer.printMenu();
    }

    Player getAttacker() {
        return players[attacker];
    }

    Player getDefender() {
        return players[1 - attacker];
    }
}