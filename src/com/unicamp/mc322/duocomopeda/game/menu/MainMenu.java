package com.unicamp.mc322.duocomopeda.game.menu;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.menu.command.*;


public class MainMenu extends Menu{

    public MainMenu(Game game) {
        super(game);
        this.name = "Main Phase";
        this.commandList.add(new PlayCardCommand());
        this.commandList.add(new StartCombatCommand());
        this.commandList.add(new PassCommand());
    }
    
}
