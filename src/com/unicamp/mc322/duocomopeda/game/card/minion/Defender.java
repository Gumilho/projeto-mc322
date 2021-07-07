package com.unicamp.mc322.duocomopeda.game.card.minion;

import java.util.EnumSet;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public class Defender extends Minion {

    public Defender(Player owner) {
        super("Defender", 2, 2, 2, EnumSet.of(Trait.FURY), owner, "Trait: Fury (+0/+1)");
    }

    @Override
    public void onKill(Minion killer, Minion killed) {
        this.buff(0, 1);
    }
}
