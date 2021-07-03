package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class StartCombatCommand extends Command {

    public StartCombatCommand() {
        super("Start Combat");
    }

    @Override
    public void getInput(Player player) {
        
        System.out.println("Player " + player.getNickname() + " started combat");
    }

    @Override
    public void execute(Player player) {
        Game game = Game.getInstance();
        game.startCombat();
    }

}
