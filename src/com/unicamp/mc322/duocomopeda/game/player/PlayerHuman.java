package com.unicamp.mc322.duocomopeda.game.player;

import java.util.Scanner;

public class PlayerHuman extends Player {

    public PlayerHuman(String nickname) {

        super(nickname);
    }

    @Override
    public int getCommandInt(Scanner keyboard, int commandQty) {
        int commandInt = keyboard.nextInt();
        while (commandInt < 0 && commandInt >= commandQty) {
            System.out.println("Invalid Command! Please enter again: ");
            commandInt = keyboard.nextInt();
        }
        return commandInt;
    }

}