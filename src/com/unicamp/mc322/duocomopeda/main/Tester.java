package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.utils.Utils;

public class Tester {

    public static void main(String[] args) {
        Utils.clearScreen();
        Game game = Game.getInstance();
        game.setupTestScenario("joao", "demacia", "maria", "demacia");
        game.startGame();
    }

}