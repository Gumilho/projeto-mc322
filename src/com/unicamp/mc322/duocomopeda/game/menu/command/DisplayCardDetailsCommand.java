package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.utils.Utils;
import com.unicamp.mc322.duocomopeda.game.Game;

public class DisplayCardDetailsCommand extends Command {

    public DisplayCardDetailsCommand(Player owner, int index) {
        super("Display Card Details", owner, index);
    }

    @Override
    public void execute() {
        System.out.print("Enter the index of the card you want to see: ");
        Player player = this.getOwner();
        int arg = player.getInputInt(player.getHandSize());
        Game game = Game.getInstance();
        game.displayDetails(arg);
        Utils.pressEnterKeyToContinue();
    }
}