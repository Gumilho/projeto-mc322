package com.unicamp.mc322.duocomopeda.game.player;

import java.util.Random;

public class PlayerAI extends Player {

    public PlayerAI(String nickname) {
        super(nickname);
    }

    @Override
    protected Command getCommand() {
        Random r = new Random();
        int commandInt = r.nextInt(3);
        switch (commandInt) {
            case 0:
                return Command.SELECT;
            case 1:
                return Command.BATTLE;
            case 2:
                return Command.PASS;        
            default:
                return null;
        }
    }
}