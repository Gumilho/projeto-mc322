package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class ConfirmUnitsCommand extends Command {

    public ConfirmUnitsCommand() {
        super("Confirm Units");
    }

    @Override
    public void execute(Player player){
        System.out.println("Player " + player + " confirmed Units");
        Game game = Game.getInstance();
        game.incrementPassedPlayers();
    }

}