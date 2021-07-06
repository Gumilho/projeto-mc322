package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Command {

    private String name;
    private Player owner;

    public Command(String name, Player owner) {
        this.name = name;
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return this.name;
    }

    public abstract void execute();


}
