package com.unicamp.mc322.duocomopeda.game.menu;

import com.unicamp.mc322.duocomopeda.game.menu.command.*;
public class CombatMenu extends Menu{

    public CombatMenu() {
        super();
        this.name = "Combat Phase";
        this.commandList.add(new PlaceUnitCommand());
        this.commandList.add(new ConfirmUnitsCommand());
    }
    
}
