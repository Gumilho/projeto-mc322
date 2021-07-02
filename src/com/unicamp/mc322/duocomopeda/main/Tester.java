package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.card.Card;
public class Tester {

    public static void main(String[] args) {
        Game game = Game.getInstance("joao", "maria");
        game.runMulligan();
        game.startGame();
    }

}