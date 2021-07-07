package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.Command;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Menu {

    private String name;
    private ArrayList<Command> commandList;
    private Player owner;
    private ArrayList<Integer> labels;

    public Menu(String name, ArrayList<Command> commandList, Player owner) {

        this.name = name;
        this.commandList = commandList;
        this.owner = owner;
        this.labels = new ArrayList<Integer>();
        for (Command command : commandList) {
            this.labels.add(command.getLabel());
        }
    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getLabels() {
        return labels;
    }

    public int getCommandListSize() {
        return commandList.size();
    }

    public ArrayList<Command> getCommandList() {
        return commandList;
    }

    public Command getCommand(int commandInt) {
        for (Command command : commandList) {
            if (command.getLabel() == commandInt) {
                return command;
            }
        }
        throw new IllegalArgumentException("No such command!");
    }

}
