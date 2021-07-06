package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class PlaceDefenderUnitCommand extends Command {

    public PlaceDefenderUnitCommand(Player owner) {
        super("Place Defender Unit", owner);
    }

    @Override
    public void execute(){
        Player player = getOwner();
        Board board = Board.getInstance();
        Minion minion = player.chooseUnit();
        System.out.print("Select the position: ");
        int battlefieldPosition = player.getInputInt(Board.MAX_BENCH_SIZE);
        board.moveDefenderUnitToBattlefield(minion, player.getIndex(), battlefieldPosition);
    }


}
