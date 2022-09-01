package com.techelevator.userinterface;

import com.techelevator.framework.Item;
import com.techelevator.framework.LogClass;
import com.techelevator.framework.Money;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserInput {

    private static Scanner sc = new Scanner(System.in);

    public static String getMainMenu(){

        // boolean variable to repeat menu if needed
        boolean repeat = true;

        do {
            System.out.println("\u001B[31m" + "\u001B[40m" + "---------------------------------------");
            System.out.println(">>> Welcome I'm Christine the Obscene Vending Machine <<<");
            System.out.println("---------------------------------------");
            System.out.println("\u001B[0m");
            System.out.println("");
            System.out.println("\u001B[40m" + "\u001B[31m" + "---------------------------------------");
            System.out.println(">>> Main Menu <<<");
            System.out.println("---------------------------------------");

            System.out.println( "\u001B[0m" + "\033[0;34m" + "\033[40m" + "1: Display Vending Machine Items >>>");
            System.out.println("2: Purchase >>>");
            System.out.println("3: Exit >>>");
            System.out.println("\u001B[0m");
            System.out.print("Please make your selection: ");


            String userOption = sc.nextLine();
            String option = userOption.trim().toLowerCase(Locale.ROOT);

            switch(option){
                case "1":
                    return "display";

                case "2":
                    return "purchase";

                case "3":
                    return "exit";

                case "4":
                    return "secret";

                default:
                    return "Please select from available options.";
            }

        }
        while(repeat);
    }

    public static String getPurchaseMenu(Money balance){

        boolean repeat = true;

        do {
            System.out.println("---------------------------------------");
            System.out.println(">>> Purchase Menu <<<");
            System.out.println("---------------------------------------");
            System.out.println();
            System.out.println("1: Inset Money >>>");
            System.out.println("2: Select Product >>>");
            System.out.println("3: Finish Transaction >>>");

            // Make sure to show balance
            System.out.println("Current Balance: " + NumberFormat.getCurrencyInstance().format(balance.getCurrentBalance()));
            System.out.println();

            String userOption = sc.nextLine();
            String option = userOption.trim().toLowerCase(Locale.ROOT);

            if(option.equals("1")) {
                return "Feed Money";
            } else if (option.equals("2")){
                return "Select Product";
            }  else if (option.equals("3")){
                repeat = false;
                return "Finish Transaction";
            }

        }
        while(repeat);
        return "";
    }

    public BigDecimal getMoney(Money balance){
        boolean repeat = true;

        do{
            System.out.println("Please insert money in the amounts of");
            System.out.println(">>> $1, $2, $5, $10 <<<");
            System.out.print("Insert money here >>> ");

            String userInput = sc.nextLine();

            try {
                BigDecimal money = balance.moneyProvided(new BigDecimal(userInput));
                LogClass.auditVendingFeedMoney(userInput, balance);
                repeat = false;
            } catch(InputMismatchException e){
                System.out.println("Please enter a whole dollar amount $1, $2, $5, $10");
            } catch(Exception e){
                System.out.println("You gotta be kitten me.");
            }
        }
        while(repeat);
        return new BigDecimal("0");
    }

    public String getProductId(List<Item> products, Money balance){

        boolean repeat = true;
        Item userItem = null;

        do {
            System.out.print("Select an item: ");
            String selected = sc.nextLine();

            for(Item item : products){
                if(item.getProductLocation().equals(selected)){
                    userItem = item;
                }
            }

            if(userItem == null){
                System.out.println("Product does not exist. Please try again!" + "\n");
                continue;
            }
            try {
                balance.updateBalance(userItem.getPrice());
                userItem.buyItem();
                LogClass.auditVendingSelection(userItem, balance);
                System.out.println("Now Dispensing " + userItem.getProductName() + ": $" + userItem.getPrice());
                System.out.println("Current Balance: " + NumberFormat.getCurrencyInstance().format(balance.getCurrentBalance()));
                System.out.println(userItem.playSound() + "\n");
                repeat = false;

            } catch(ArithmeticException e) {

            } catch(Exception e){
                repeat = false;
            }
        } while (repeat);
        return "";
    }
}