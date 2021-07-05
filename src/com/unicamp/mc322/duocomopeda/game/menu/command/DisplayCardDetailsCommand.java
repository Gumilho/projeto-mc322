package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.Game;

public class DisplayCardDetailsCommand extends Command {
    
    public DisplayCardDetailsCommand() {
        super("Display Card Details");
    }

    @Override
    public void execute(Player player){
        System.out.print("Enter the index of the card you want to see: ");
        arg = player.getInputInt(player.getHandSize());
        Game game = Game.getInstance();
        game.displayDetails(arg);
    }
}