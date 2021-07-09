package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class PlayCardCommand extends Command {

    public PlayCardCommand(Player owner, int index) {
        super("Play", owner, index);
    }

    @Override
    public void execute() {
        Player player = getOwner();
        System.out.print("Enter the index of the card you want to play: ");
        Card card = player.chooseHandCard();
        player.playFromHand(card);
    }
}
