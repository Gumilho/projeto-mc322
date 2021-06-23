package com.unicamp.mc322.duocomopeda.game.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.unicamp.mc322.duocomopeda.game.Game;
import com.unicamp.mc322.duocomopeda.game.menu.command.Command;

public abstract class Menu {
    protected String name;
    protected Game game;
    private ArrayList<Command> commandList;
    private Scanner keyboard;

    public Menu(Game game) {
        this.game = game;
        this.name = "abstract-menu";
        this.keyboard = new Scanner(System.in);
    }

    public Command read() {
        printHeader();
        printOptions();
        System.out.print("Choose one of the options (type the associated number and press enter):");
        int commandInt = keyboard.nextInt();
        return commandList.get(commandInt);
    }

    private void printHeader() {
        int nameSize = name.length();
        for (int i = 0; i < nameSize + 2; i++) {
            System.out.print("#");
        }
        System.out.println();

        System.out.print("#");
        System.out.print(name);
        System.out.println("#");

        for (int i = 0; i < nameSize + 2; i++) {
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
