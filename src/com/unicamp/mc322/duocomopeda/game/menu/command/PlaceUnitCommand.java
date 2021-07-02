package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class PlaceUnitCommand extends Command {

    public PlaceUnitCommand() {
        super("Place Unit");
    }


    @Override
    public void getInput(Player player){
        System.out.println("Select your unit: ");
        args[0] = player.getInputInt(6);
    }

    @Override
    public void execute(Player player) {
        Board board = Board.getInstance();
        board.moveUnitToBattlefield(args[0]);
    }

}
