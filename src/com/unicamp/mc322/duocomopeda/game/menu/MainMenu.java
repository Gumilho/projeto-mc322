package com.unicamp.mc322.duocomopeda.game.menu;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.menu.command.*;


public class MainMenu extends Menu{

    public MainMenu(Game game) {
        super(game);
        this.name = "Main Menu";
        this.commandList.add(new PassCommand());
    }
    
}
