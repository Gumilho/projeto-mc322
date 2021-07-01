package com.unicamp.mc322.duocomopeda.game.menu.command;


import com.unicamp.mc322.duocomopeda.game.player.Player;

public class PlayCardCommand extends Command {

    public PlayCardCommand() {
        super("Play");
    }

    @Override
    public void execute(Player player){
        System.out.println("Player " + player.getNickname() + " passed turn");
        int inputInt = player.getInputInt(6);
        player.pass();
    }

}
