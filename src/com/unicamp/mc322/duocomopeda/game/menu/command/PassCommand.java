package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

import com.unicamp.mc322.duocomopeda.game.Game;

public class PassCommand extends Command {

    public PassCommand(Player owner, int index) {
        super("Pass", owner, index);
    }

    @Override
    public void execute() {
        System.out.println("Player " + getOwner() + " passed turn");
        Game game = Game.getInstance();
        game.incrementPassedPlayers();
    }

}
