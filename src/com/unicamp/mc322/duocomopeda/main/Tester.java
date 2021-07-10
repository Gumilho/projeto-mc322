package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.TextualGraphicsEngine;

public class Tester {

    public static void main(String[] args) {
        TextualGraphicsEngine.clearScreen();
        Game game = Game.getInstance();
        game.setupTestScenario("joao", "poro", "maria", "poro");
        game.startGame();
    }

}