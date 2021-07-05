package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class StartCombatCommand extends Command {

    public StartCombatCommand() {
        super("Start Combat");
    }

    @Override
    public void execute(Player player) {
        
        System.out.println("Player " + player + " started combat");
        Game game = Game.getInstance();
        game.startCombat();
    }


}
