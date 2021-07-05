package com.unicamp.mc322.duocomopeda.game.event;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Event {
    
    private Player owner;

    public Event(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
