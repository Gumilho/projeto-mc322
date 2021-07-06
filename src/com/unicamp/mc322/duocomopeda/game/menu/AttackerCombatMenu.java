package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.*;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class AttackerCombatMenu extends Menu {
    
    public AttackerCombatMenu(Player owner) {
        super("Attacker Combat Phase", new ArrayList<Command>() {
            {
                add(new DisplayCardDetailsCommand(owner));
                add(new PlaceAttackerUnitCommand(owner));
                add(new ConfirmUnitsCommand(owner));
                add(new EndGameCommand(owner));
            }
        }, owner);
    }
}
