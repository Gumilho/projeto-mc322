package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Command {

    private String name;
    int[] args;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int[] getArgs() {
        return args;
    }

    protected void setArgs(int[] args) {
        this.args = args;
    }

    public abstract void getInput(Player player);

    public abstract void execute(Player player);

}
