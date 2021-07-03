package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class ConfirmUnitsCommand extends Command {

    public ConfirmUnitsCommand() {
        super("Confirm Units");
    }

    @Override
    public void getInput(Player player){
        System.out.println("Player " + player.getNickname() + " passed turn");
    }

    @Override
    public void execute() {
        Game game = Game.getInstance();
        game.incrementPassedPlayers();
    }

}