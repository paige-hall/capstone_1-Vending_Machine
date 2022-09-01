package com.techelevator.app;

import com.techelevator.framework.Item;
import com.techelevator.framework.*;
import com.techelevator.userinterface.UserInput;
import com.techelevator.userinterface.UserOutput;
import com.techelevator.framework.Money;

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private List<Item> products = new ArrayList<>();
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK

    public List<Item> startedMachine(){

        File file = new File("/home/kory/Repos/module-1-capstone/capstone/vendingmachine.csv");
        try {
            Scanner fScanner = new Scanner(file);

            while(fScanner.hasNextLine()){
                String line = fScanner.nextLine();
                String[] lineSplit = line.split("\\|");


                switch (lineSplit[3]) {
                    case "Chip": {
                        Item item = new Chip(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        products.add(item);
                        break;
                    }
                    case "Candy": {
                        Item item = new Candy(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        products.add(item);
                        break;
                    }
                    case "Drink": {
                        Item item = new Drink(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        products.add(item);
                        break;
                    }
                    case "Gum": {
                        Item item = new Gum(lineSplit[1], lineSplit[0], new BigDecimal(lineSplit[2]));
                        products.add(item);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid");
            System.exit(1);
        }
        return products;
    }

    public void run(){
        List<Item> items = startedMachine();

        label:
        while(true){
            UserOutput.displayHomeScreen();
            String option = UserInput.getMainMenu();

            switch (option) {
                case "display":

                    for (Item item : items) {
                        System.out.println((ANSI_PURPLE + item.getProductLocation() + ANSI_RESET + " >> " + GREEN_BRIGHT + item.getProductName()
                                + ANSI_RESET + " >> " + RED_BRIGHT + item.getPrice() + ANSI_RESET + " >> " + item.getAmtAvailable()));
                    }
                    break;
                case "purchase":
                    lvl2();
                    break;
                case "exit":
                    System.out.println("Bye bye now.");
                    break label;
            }
        }

    }

    public void lvl2(){
        Money balance = new Money();

        label:
        while(true){
            UserInput input = new UserInput();

            String option = UserInput.getPurchaseMenu(balance);

            switch (option) {
                case "Feed Money":
                    input.getMoney(balance);
                    break;
                case "Select Product":
                    for (Item item : products) {
                        System.out.println(item.getProductLocation() + " | " + item.getProductName() + " | " + item.getPrice());
                    }
                    input.getProductId(products, balance);
                    break;
                case "Finish Transaction":
                    System.out.println(balance.makeChange());
                    System.out.println(GREEN_BRIGHT + "Current balance in machine: " + NumberFormat.getCurrencyInstance().format(balance.getCurrentBalance()) + ANSI_RESET);
                    break label;
            }
        }


    }

}
