package com.techelevator.framework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class Money {

    // current balance
    private BigDecimal currentBalance = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);

    public BigDecimal getCurrentBalance(){
        return currentBalance;
    }

    public BigDecimal updateBalance(BigDecimal itemPrice) throws Exception {
        if (itemPrice.compareTo(currentBalance) <= 0) {
            return currentBalance = currentBalance.subtract(itemPrice);
        } else {
            System.out.println("Please insert more money!");
            throw new Exception();
        }
    }


    public BigDecimal moneyProvided(BigDecimal customerMoney) throws InputMismatchException {

        try {
            if (customerMoney.equals(new BigDecimal("1")) ||
                    customerMoney.equals(new BigDecimal("2")) ||
                    customerMoney.equals(new BigDecimal("5")) ||
                    customerMoney.equals(new BigDecimal("10"))) {
                currentBalance = currentBalance.add(customerMoney);
            } else {
                throw new InputMismatchException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }
        return currentBalance;
    }

    public String makeChange(){
        String output = "";
        int dollars = currentBalance.multiply(new BigDecimal("100")).intValue();
        int quarters = dollars / 25;
        dollars = dollars % 25;

        int dimes = dollars / 10;
        dollars = dollars % 10;

        int nickles = dollars / 5;
        dollars = dollars % 5;

        if(dollars % 5 == 0){
            output = "Your change: " + quarters + " Quarters, " + dimes + " Dimes, " + nickles + " Nickles";
        }
        return output;
    }

}