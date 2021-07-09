package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.utils.Utils;
import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.card.Card;

public class DisplayCardDetailsCommand extends Command {

    public DisplayCardDetailsCommand(Player owner, int index) {
        super("Display Card Details", owner, index);
    }

    @Override
    public void execute() {
        Game game = Game.getInstance();
        System.out.print("Enter the index of the card you want to see: ");
        Player player = this.getOwner();
        Card card = player.chooseHandCard();
        game.flipTurn();
        card.displayDetails();
        Utils.pressEnterKeyToContinue();
    }
}