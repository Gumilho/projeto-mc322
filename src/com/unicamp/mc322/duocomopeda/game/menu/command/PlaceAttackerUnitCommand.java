package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Board;
import com.unicamp.mc322.duocomopeda.game.player.Player;
import com.unicamp.mc322.duocomopeda.game.card.minion.Minion;

public class PlaceAttackerUnitCommand extends Command {

    public PlaceAttackerUnitCommand(Player owner, int index) {
        super("Place Attacker Unit", owner, index);
    }

    @Override
    public void execute() {
        Player player = getOwner();
        Board board = Board.getInstance();
        Minion minion = player.chooseAllyUnit();
        System.out.print("Select the position: ");
        int battlefieldPosition = player.getInputInt(Board.MAX_BENCH_SIZE);
        board.moveAttackerUnitToBattlefield(minion, player, battlefieldPosition);
    }
}
