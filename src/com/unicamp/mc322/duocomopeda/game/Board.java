package com.unicamp.mc322.duocomopeda.game;

import com.unicamp.mc322.duocomopeda.game.card.Card;

public class Board {

    private static Board board;
    
    private Card[] bench;
    
    private Card[] battleField;
    
    private Board() {
        this.bench = new Card[6];
        this.battleField = new Card[6];
    }

    private void resolveBattle() {
        // TODO implement here
    }

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

}