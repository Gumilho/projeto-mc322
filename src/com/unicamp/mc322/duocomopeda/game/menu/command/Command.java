package com.unicamp.mc322.duocomopeda.game.menu.command;

import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Command {

    private String name;
    int arg;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void getInput(Player player);

    public abstract void execute();

}
