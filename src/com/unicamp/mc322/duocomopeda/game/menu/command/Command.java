package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Command {

    private String name;
    private Player owner;
    private int label;

    public Command(String name, Player owner, int label) {
        this.name = name;
        this.owner = owner;
        this.label = label;
    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return this.name;
    }

    public int getLabel() {
        return label;
    }

    public abstract void execute();

}
