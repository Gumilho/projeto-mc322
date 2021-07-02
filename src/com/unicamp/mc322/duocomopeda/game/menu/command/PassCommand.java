package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public class PassCommand extends Command {

    public PassCommand() {
        super("Pass");
    }


    @Override
    public void getInput(Player player){
        System.out.println("Player " + player.getNickname() + " passed turn");
        player.pass();
    }

    @Override
    public void execute(Player player) {
        // TODO Auto-generated method stub
        
    }

}
