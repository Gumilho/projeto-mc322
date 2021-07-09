package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.card.Card;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class SwapCardCommand extends Command {

    public SwapCardCommand(Player owner, int label) {
        super("Swap Card", owner, label);
    }

    @Override
    public void execute() {
        Player player = getOwner();
        System.out.print("Enter the card you want to play: ");
        Card handCard = player.chooseHandCard();
        Minion benchCard = player.chooseAllyUnit();
        player.swapCard(handCard, benchCard);

    }
}
