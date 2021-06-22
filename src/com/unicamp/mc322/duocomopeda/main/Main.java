package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.startGame();
    }

}