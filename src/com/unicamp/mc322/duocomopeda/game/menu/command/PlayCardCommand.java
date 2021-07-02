package com.unicamp.mc322.duocomopeda.game.menu.command;


import com.unicamp.mc322.duocomopeda.game.player.Player;

public class PlayCardCommand extends Command {

    public PlayCardCommand() {
        super("Play");
    }

    @Override
    public void getInput(Player player){
        System.out.println("Enter the index of the card you want to play: ");
        int inputInt = player.getInputInt(10);
        args[0] = inputInt;
    }
    @Override
    public void execute(Player player) {
        player.playFromHand(args[0]);
    }
}
