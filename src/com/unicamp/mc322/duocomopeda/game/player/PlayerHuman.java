package com.unicamp.mc322.duocomopeda.game.player;

import java.util.Scanner;

public class PlayerHuman extends Player {

    private Scanner keyboard;

    public PlayerHuman(String nickname, Scanner keyboard, int index, int attacker) {
        super(nickname, index, index == attacker);
        this.keyboard = keyboard;
    }

    @Override
    public int getInputInt(int maxInt) {
        int inputInt = keyboard.nextInt();
        
        while (inputInt < 0 && inputInt >= maxInt) {
            System.out.print("\nInvalid Command! Please enter again: ");
            inputInt = keyboard.nextInt();
        }
        return inputInt;
    }
}