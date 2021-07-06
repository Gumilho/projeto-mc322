package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.*;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class DefenderMainMenu extends Menu {
    
    public DefenderMainMenu(Player owner) {
        super("Defender Main Phase", new ArrayList<Command>() {
            {
                add(new DisplayCardDetailsCommand(owner));
                add(new PlayCardCommand(owner));
                add(new PassCommand(owner));
                add(new EndGameCommand(owner));
            }
        }, owner);
    }
}
