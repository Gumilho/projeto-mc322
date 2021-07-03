package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;
public class Tester {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.setup("joao", "maria");
        game.runMulligan(0);
        game.runMulligan(1);
        game.startGame();
    }

}