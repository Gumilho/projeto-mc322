package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Poro extends Minion {

    public Poro(Player owner) {
        super(
            "Poro", 
            1, 
            2, 
            1, 
            EnumSet.noneOf(Trait.class),
            owner
        );
    }

}
