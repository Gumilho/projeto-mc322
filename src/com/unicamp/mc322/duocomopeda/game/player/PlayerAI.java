package com.unicamp.mc322.duocomopeda.game.player;

import java.util.Random;

public class PlayerAI extends Player {

    public PlayerAI(String nickname, int index, int attacker) {
        super(nickname, index, index == attacker);
    }

    @Override
    public int getInputInt(int maxInt) {
        Random r = new Random();
        int inputInt = r.nextInt(maxInt);
        System.out.println(inputInt);
        return inputInt;
    }
}