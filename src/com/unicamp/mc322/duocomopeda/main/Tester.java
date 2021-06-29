package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;
public class Tester {

    public static void main(String[] args) {
        Game game = Game.getInstance("joao", "maria");
        game.startGame();
    }

}