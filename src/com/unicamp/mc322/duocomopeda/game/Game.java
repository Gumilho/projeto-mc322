package com.unicamp.mc322.duocomopeda.game;

import java.util.Random;
import java.util.Scanner;

import com.unicamp.mc322.duocomopeda.game.player.*;
import com.unicamp.mc322.duocomopeda.game.card.minion.Poro;
import com.unicamp.mc322.duocomopeda.game.menu.*;
import com.unicamp.mc322.duocomopeda.game.menu.command.Command;

public class Game {

    private static Game game;

    private Player[] players;
    private Board board;
    private Menu menu;
    private Scanner keyboard;
    private Player currentPlayer;

    private int roundCounter;
    private int attacker;
    private int turn;
    
    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private Game() {
        this.roundCounter = 1;
        this.board = Board.getInstance();
        this.keyboard = new Scanner(System.in);
        this.menu = new MainMenu(this);
        this.players = new Player[2];
    }

    public void setup() {
        this.setupPlayers();
        this.chooseAttacker();
        this.setupDecks();
    }

    public void setup(String nickname1, String nickname2) {
        this.players = new Player[2];
        players[0] = new PlayerHuman(nickname1, keyboard);
        players[1] = new PlayerHuman(nickname2, keyboard);
        this.chooseAttacker();
        this.setupDecks();
    }

    public void runMulligan() {
        System.out.println("Player 1 Mulligan");
        players[0].printHand();
        System.out.println("Which card do you want to swap? (enter 5 for none)");
        boolean[] swapList = new boolean[4];
        int input = players[0].getInputInt(5);
        while (input != 5) {
            swapList[input] = !swapList[input];
            System.out.println("Do you want to change another one? Press 5 if you're done");
            input = players[0].getInputInt(5);
        }
        for (int i = 0; i < 4; i++) {
            if (swapList[input]) {
                players[0].swap(input);
            }
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public void startGame() {

        while(true) { // change this later
            startRound();
            int pass = 0;
            int turnToken = attacker;
            while(pass < 2) {
                
                currentPlayer = players[turnToken];
                printBoard();
                readInput();

                // Process pass counts
                if (currentPlayer.getPassed()) {
                    pass++;
                } else {
                    pass = 0;
                }
                
                turnToken = 1 - turnToken; // flips the token
            }
            advanceRound();
        }
    }

    public void startCombat() {
        this.menu = new CombatMenu(this);
    }

    private void setupDecks() {
        this.players[0].setDeck(createDeck("demacia"));
    }

    private Deck createDeck(String deckName) {
        Deck newDeck = new Deck();
        switch (deckName) {
            case "demacia":
                newDeck.addCard(new Poro());
                newDeck.addCard(new Poro());
                newDeck.addCard(new Poro());
                newDeck.addCard(new Poro());
                newDeck.addCard(new Poro());
                break;

            default:
                System.out.println("Deck not found");
                break;
        }
        return newDeck;
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
            players[playerIndex] = new PlayerHuman(name, keyboard);
        } else if (type.compareTo("A") == 0) {
            players[playerIndex] = new PlayerAI(name);
        }

    }

    private void chooseAttacker() {

        Random r = new Random();
        this.attacker = r.nextInt(2);
        System.out.println("Player " + players[attacker].getNickname() + " starts attacking.");
        
    }

    private void setupPlayers() {

        enterPlayerInfo(0);
        enterPlayerInfo(1);

    }

    private void startRound() {
        players[0].startRound();
        players[1].startRound();
    }

    private void advanceRound() {
        attacker = 1 - attacker;
        System.out.print("\n\n");
        System.out.println("ROUND " + String.format("%d", roundCounter + 1));
        System.out.println("Player " + players[attacker].getNickname() + " is attacking now.\n");
    }

    private void printBoard() {
        board.print();
        currentPlayer.printHand();
        menu.printMenu();
    }

    private void readInput() {
        int commandInt = currentPlayer.getInputInt(menu.getCommandListSize());
        Command command = menu.getCommand(commandInt);
        command.execute(currentPlayer);
    }


    public CardDatabase getDb() {
        return db;
    }
}