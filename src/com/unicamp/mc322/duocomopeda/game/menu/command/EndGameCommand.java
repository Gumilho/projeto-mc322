package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class EndGameCommand extends Command {

    public EndGameCommand(Player owner, int index) {
        super("End Game", owner, index);
    }

    @Override
    public void execute() {
        System.out.println("Player " + getOwner() + " ended game");
        Game game = Game.getInstance();
        game.endGame();
    }

}