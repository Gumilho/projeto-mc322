package com.unicamp.mc322.duocomopeda.game;

import java.util.Random;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Game {

    public static Game game;

    private Player[] players;

    private Board board;

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
        this.setupPlayers();
        this.setupBoard();
    }

    private void setupBoard() {
        this.board = Board.getInstance();
    }

    private void setupPlayers() {
        this.players = new Player[2];
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
        System.out.println("Player " + players[attacker].getNickname() + " is attacking now.");
    }

    private void printBoard() {
        // how to print for two players
    }

    public void startGame() {
        printBoard();
        while(true) { // change this later
            startRound();
            int pass = 0;
            int currentPlayer = attacker;
            while(pass < 2) {
                players[currentPlayer].act();
                if (players[currentPlayer].getPassed()) {
                    pass++;
                } else {
                    pass = 0;
                }
                currentPlayer = 1 - currentPlayer;
                printBoard();

            }
            advanceRound();
        }
    }

}