package com.unicamp.mc322.duocomopeda.game;

import java.util.Random;
import java.util.Scanner;

import com.unicamp.mc322.duocomopeda.game.player.*;
import com.unicamp.mc322.duocomopeda.game.menu.*;
import com.unicamp.mc322.duocomopeda.game.menu.command.Command;

public class Game {

    public static Game game;

    private Player[] players;
    private Board board;
    private Menu menu;
    private Scanner keyboard;

    private int roundCounter;
    private int attacker;
    private int turn;
    

    public static Game getInstance(String nickname1, String nickname2) {
        if (game == null) {
            game = new Game(nickname1, nickname2);
        }
        return game;
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private Game() {
        this.roundCounter = 1;
        this.setupPlayers();
        this.setupBoard();
        this.keyboard = new Scanner(System.in);
        this.menu = new MainMenu(this);
    }

    // Test environment function
    private Game(String nickname1, String nickname2) {
        this.roundCounter = 1;
        this.setupPlayers(nickname1, nickname2);
        this.setupBoard();
        this.keyboard = new Scanner(System.in);
        this.menu = new MainMenu(this);
    }

    private void setupBoard() {
        this.board = Board.getInstance();
    }

    private void setupPlayers() {
        this.players = new Player[2];
        String type, name;

        System.out.print("Enter Player 1 type [(H)uman/(A)I]: ");
        type = keyboard.nextLine();
        System.out.print("Enter Player 1 name: ");
        name = keyboard.nextLine();
        if (type.compareTo("H") == 0) {
            players[0] = new PlayerHuman(name);
        } else if (type.compareTo("A") == 0) {
            players[0] = new PlayerAI(name);
        }

        System.out.print("Enter Player 2 type [(H)uman/(A)I]: ");
        type = keyboard.nextLine();
        System.out.print("Enter Player 2 name: ");
        name = keyboard.nextLine();
        if (type.compareTo("H") == 0) {
            players[1] = new PlayerHuman(name);
        } else if (type.compareTo("A") == 0) {
            players[1] = new PlayerAI(name);
        }

        Random r = new Random();
        this.attacker = r.nextInt(2);
        System.out.println(players[attacker]);
        System.out.println("Player " + players[attacker].getNickname() + " starts attacking.");
        
    }
    
    // Test environment function
    private void setupPlayers(String nickname1, String nickname2) {
        this.players = new Player[2];
        players[0] = new PlayerHuman(nickname1);
        players[1] = new PlayerHuman(nickname2);
        Random r = new Random();
        this.attacker = r.nextInt(2);
        System.out.println("Player " + players[attacker].getNickname() + " starts attacking.");
        
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
        // how to print for two players
    }

    public void startGame() {
        printBoard();
        while(true) { // change this later
            startRound();
            int pass = 0;
            int turnToken = attacker;
            while(pass < 2) {

                Player currentPlayer = players[turnToken];
                menu.printMenu();
                int commandInt = currentPlayer.getCommandInt(keyboard, menu.getCommandListSize());
                Command command = menu.getCommand(commandInt);
                command.execute(currentPlayer);
                if (currentPlayer.getPassed()) {
                    pass++;
                } else {
                    pass = 0;
                }
                turnToken = 1 - turnToken; // flips the token
                printBoard();

            }
            advanceRound();
        }
    }

}