package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

import com.unicamp.mc322.duocomopeda.game.Game;
public class PassCommand extends Command {

    public PassCommand() {
        super("Pass");
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
