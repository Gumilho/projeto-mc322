package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class StartCombatCommand extends Command {

    public StartCombatCommand(Player owner, int index) {
        super("Start Combat", owner, index);
    }

    @Override
    public void execute() {
        System.out.println("Player " + getOwner() + " started combat");
        Game game = Game.getInstance();
        game.startCombat();
    }

}
