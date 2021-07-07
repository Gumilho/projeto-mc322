package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

import com.unicamp.mc322.duocomopeda.game.Game;

public class PlayCardCommand extends Command {

    public PlayCardCommand(Player owner, int index) {
        super("Play", owner, index);
    }

    @Override
    public void execute() {
        Game game = Game.getInstance();
        Player player = getOwner();
        System.out.print("Enter the index of the card you want to play: ");
        int cardIndex = player.getInputInt(10);
        game.playFromHand(cardIndex);
    }
}
