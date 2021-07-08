package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;
import java.util.Random;

public class PlayerAI extends Player {

    public PlayerAI(String nickname, int index, int attacker, String deckName) {
        super(nickname, index, index == attacker, deckName);
    }

    @Override
    public int getInputInt(ArrayList<Integer> labels) {
        Random r = new Random();
        int inputInt = r.nextInt(labels.size());
        System.out.println(labels.get(inputInt));
        return labels.get(inputInt);
    }
}