package com.techelevator.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogClass {

    public static void auditVendingFeedMoney(String userInput, Money balance){
        File logFile = new File("log.txt");

        DateTimeFormatter tFormat =DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

        String log = LocalDateTime.now().format(tFormat) + " FEED MONEY: "
                + NumberFormat.getCurrencyInstance().format(new BigDecimal(userInput)) + ", "
                + NumberFormat.getCurrencyInstance().format(balance.getCurrentBalance()) + "\n";

        PrintWriter pw = null;

        try {
            if(logFile.exists()){
                pw = new PrintWriter(new FileOutputStream(logFile.getAbsoluteFile(), true));
            }
            else {
                pw = new PrintWriter(logFile.getAbsoluteFile());
            }
        } catch (FileNotFoundException e){
            System.out.println("No file found.");
        }

        pw.append(log);
        pw.flush();
        pw.close();

    }

    public static void auditVendingSelection(Item item, Money balance){
        File logFile = new File("log.txt");

        DateTimeFormatter tFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String log = LocalDateTime.now().format(tFormat) + " " + item.getProductName() + " " + item.getProductLocation() + ": "
                + NumberFormat.getCurrencyInstance().format(balance.getCurrentBalance().add(item.getPrice())) + ", "
                + NumberFormat.getCurrencyInstance().format(balance.getCurrentBalance()) + "\n";

        PrintWriter pw = null;

        try {
            if(logFile.exists()) {
                pw = new PrintWriter(new FileOutputStream(logFile.getAbsoluteFile(), true));
            } else {
                pw = new PrintWriter(logFile.getAbsoluteFile());
            }

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        pw.append(log);
        pw.flush();
        pw.close();


    }

    public static void auditVendingFinishTransaction(BigDecimal currentMoney, BigDecimal dollars) {

        File logFile = new File("log.txt");

        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String log = LocalDateTime.now().format(targetFormat) + " GIVE CHANGE: "
                + NumberFormat.getCurrencyInstance().format(currentMoney) + ", "
                + NumberFormat.getCurrencyInstance().format(dollars) + "\n";

        PrintWriter pw = null;

        try {
            if (logFile.exists()) {
                pw = new PrintWriter(new FileOutputStream(logFile.getAbsoluteFile(), true));
            } else {
                pw = new PrintWriter(logFile.getAbsoluteFile());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        pw.append(log);
        pw.flush();
        pw.close();
    }
}

