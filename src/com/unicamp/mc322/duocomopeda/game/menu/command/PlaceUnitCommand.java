package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class PlaceUnitCommand extends Command {

    public PlaceUnitCommand() {
        super("Place Unit");
    }

    @Override
    public void execute(Player player){
        Board board = Board.getInstance();
        Minion minion = player.chooseUnit();
        board.moveUnitToBattlefield(minion, player.getIndex());
    }


}
