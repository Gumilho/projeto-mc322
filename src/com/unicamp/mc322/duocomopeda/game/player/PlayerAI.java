package com.unicamp.mc322.duocomopeda.game.player;

import java.util.Random;
import java.util.Scanner;

public class PlayerAI extends Player {

    public PlayerAI(String nickname) {
        super(nickname);
    }

    @Override
    public int getCommandInt(Scanner keyboard, int commandQty) {
        Random r = new Random();
        int commandInt = r.nextInt(commandQty);
        System.out.println(commandInt);
        return commandInt;
    }
}