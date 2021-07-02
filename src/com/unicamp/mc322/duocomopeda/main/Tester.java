package com.unicamp.mc322.duocomopeda.main;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.card.Card;
public class Tester {

    public static void main(String[] args) {
        // Clearing screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        Game game = Game.getInstance("joao", "maria");
        Card newCard = game.getDb().getCard("DE006");
        newCard.setCost(2);
        game.startGame();
    }

}