package com.unicamp.mc322.duocomopeda.game.menu.command;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}