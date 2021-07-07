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

    public ArrayList<Integer> getLabels() {
        return labels;
    }

    public int getCommandListSize() {
        return commandList.size();
    }

    public void print() {
        printHeader();
        printOptions();
        System.out.print("Choose one of the options (type the associated number and press enter): ");
    }

    public Command getCommand(int commandInt) {
        for (Command command : commandList) {
            if (command.getLabel() == commandInt) {
                return command;
            }
        }
        throw new IllegalArgumentException("No such command!");
    }

    private void printHeader() {
        int nameSize = name.length();
        System.out.println();
        for (int i = 0; i < nameSize + 4; i++) {
            System.out.print("#");
        }
        System.out.println();

        System.out.print("# ");
        System.out.print(name);
        System.out.println(" #");

        for (int i = 0; i < nameSize + 4; i++) {
            System.out.print("#");
        }
        System.out.println();

    }

    private void printOptions() {
        for (Command command : commandList) {
            System.out.print(command.getLabel());
            System.out.print(" - ");
            System.out.println(command.getName());
        }
    }
}
