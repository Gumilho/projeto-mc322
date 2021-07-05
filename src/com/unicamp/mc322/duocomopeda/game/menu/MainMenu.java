package com.unicamp.mc322.duocomopeda.game.menu;

import com.unicamp.mc322.duocomopeda.game.menu.command.*;


public class MainMenu extends Menu{

    public MainMenu(boolean isAttacker) {
        super();
        this.name = "Main Phase";
        this.commandList.add(new PlayCardCommand());
        if (isAttacker) {
            this.commandList.add(new StartCombatCommand());
        }
        this.commandList.add(new PassCommand());
        this.commandList.add(new EndGameCommand());
    }
    
}
