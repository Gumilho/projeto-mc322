package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public class PassCommand extends Command {

    public PassCommand() {
        super("Pass");
    }

    @Override
    public void execute(Player player){
        System.out.println("player passed turn");
        player.pass();
    }

}
