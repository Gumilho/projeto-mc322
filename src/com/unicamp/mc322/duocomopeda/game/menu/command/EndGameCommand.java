package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class EndGameCommand extends Command {

    public EndGameCommand() {
        super("End Game");
    }

    @Override
    public void execute(Player player){
        System.out.println("Player " + player + " ended game");
        Game game = Game.getInstance();
        game.endGame();
    }

}