package com.techelevator.userinterface;

public class UserOutput {

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("\033[0;36m" + "\033[40m" + "***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println("\u001B[0m");
    }

}

