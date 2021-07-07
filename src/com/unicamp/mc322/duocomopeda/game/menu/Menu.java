package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;

import com.unicamp.mc322.duocomopeda.game.menu.command.Command;
import com.unicamp.mc322.duocomopeda.game.player.Player;

public abstract class Menu {
    private String name;
    private ArrayList<Command> commandList;
    private Player owner;

    public Menu(String name, ArrayList<Command> commandList, Player owner) {

        this.name = name;
        this.commandList = commandList;
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
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
        return commandList.get(commandInt);
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
        for (int i = 0; i < commandList.size(); i++) {
            System.out.print(i);
            System.out.print(" - ");
            System.out.println(commandList.get(i).getName());
        }
    }
}
