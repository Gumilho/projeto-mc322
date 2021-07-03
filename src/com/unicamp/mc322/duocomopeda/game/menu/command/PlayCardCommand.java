package com.unicamp.mc322.duocomopeda.game.menu.command;


import com.unicamp.mc322.duocomopeda.game.player.Player;

import com.unicamp.mc322.duocomopeda.game.Game;
public class PlayCardCommand extends Command {

    public PlayCardCommand() {
        super("Play");
    }

    @Override
    public void getInput(Player player){
        System.out.println("Enter the index of the card you want to play: ");
        arg = player.getInputInt(10);
    }
    @Override
    public void execute(Player player) {
        Game game = Game.getInstance();
        game.playFromHand(arg);
    }
}
