package com.unicamp.mc322.duocomopeda.game.card.effect;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Trigger {
    private Player owner;

    public Trigger(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
