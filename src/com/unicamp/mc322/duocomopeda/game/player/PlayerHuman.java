package com.unicamp.mc322.duocomopeda.game.player;

import java.util.Scanner;

public class PlayerHuman extends Player {

    public PlayerHuman(String nickname) {
        super(nickname);
    }

    @Override
    protected Command getCommand() {
        Scanner input = new Scanner(System.in);
        String commandString = input.nextLine();
        input.close();
        switch (commandString) {
            case "select":
                return Command.SELECT;
            case "play":
                return Command.PLAY;
            case "battle":
                return Command.BATTLE;
            case "pass":
                return Command.PASS;        
            default:
                return null;
        }
    }

}