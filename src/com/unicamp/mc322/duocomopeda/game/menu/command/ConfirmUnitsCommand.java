package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class ConfirmUnitsCommand extends Command {

    public ConfirmUnitsCommand(Player owner) {
        super("Confirm Units", owner);
    }

    @Override
    public void execute() {
        System.out.println("Player " + getOwner() + " confirmed Units");
        Game game = Game.getInstance();
        game.incrementPassedPlayers();
    }

}