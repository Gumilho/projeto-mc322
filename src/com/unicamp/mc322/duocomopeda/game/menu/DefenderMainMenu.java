package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.*;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public class DefenderMainMenu extends Menu {

    public DefenderMainMenu(Player owner) {
        super("Defender Main Phase", new ArrayList<Command>() {
            {
                add(new DisplayCardDetailsCommand(owner, 1));
                add(new PlayCardCommand(owner, 2));
                add(new SwapCardCommand(owner, 3));
                add(new PassCommand(owner, 4));
                add(new EndGameCommand(owner, 9));
            }
        }, owner);
    }
}
