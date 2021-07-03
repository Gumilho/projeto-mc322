package com.unicamp.mc322.duocomopeda.utils;

public class Utils {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void pressEnterKeyToContinue() { 
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch(Exception e) {}  
    }

    
}
