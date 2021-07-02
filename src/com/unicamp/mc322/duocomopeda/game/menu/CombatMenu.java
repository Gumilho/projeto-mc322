package com.unicamp.mc322.duocomopeda.game.menu;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.menu.command.*;


public class CombatMenu extends Menu{

    public CombatMenu(Game game) {
        super(game);
        this.name = "Combat Phase";
        this.commandList.add(new PlaceUnitCommand());
        this.commandList.add(new PassCommand());
    }
    
}
