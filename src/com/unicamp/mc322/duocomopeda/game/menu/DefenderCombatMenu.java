package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.*;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class DefenderCombatMenu extends Menu {

    public DefenderCombatMenu(Player owner) {
        super("Defender Combat Phase", new ArrayList<Command>() {
            {
                add(new DisplayCardDetailsCommand(owner, 1));
                add(new PlaceDefenderUnitCommand(owner, 2));
                add(new ConfirmUnitsCommand(owner, 3));
                add(new EndGameCommand(owner, 9));
            }
        }, owner);
    }
}
