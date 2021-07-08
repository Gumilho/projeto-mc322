package com.unicamp.mc322.duocomopeda.game.player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHuman extends Player {

    private Scanner keyboard;

    public PlayerHuman(String nickname, Scanner keyboard, int index, int attacker, String deckName) {
        super(nickname, index, index == attacker, deckName);
        this.keyboard = keyboard;
    }

    @Override
    public int getInputInt(ArrayList<Integer> labels) {
        int inputInt = keyboard.nextInt();
        if (!labels.contains(inputInt)) {
            throw new IllegalArgumentException("No such label");
        }
        return inputInt;
    }
}