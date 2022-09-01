package com.techelevator.framework;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {



    @Test
    void updateBalanceTest() {
        Money balance = new Money();
        balance.moneyProvided(new BigDecimal("5"));
        BigDecimal item = new BigDecimal("1.50");
        BigDecimal result = null;

        try {
            result = balance.updateBalance(item);
        } catch (Exception e){
            assertEquals(balance.getCurrentBalance(), result);
        }
    }

    @Test
    void purchaseTestBalanceUpdate(){
        Money balance = new Money();
        Candy candy = new Candy("Nirvana CD", "A1", new BigDecimal(7.00));
        balance.moneyProvided(new BigDecimal(10.00));
        BigDecimal price = candy.getPrice();
        try {
            BigDecimal result = balance.updateBalance(price);
        } catch (Exception e) {
            assertEquals(3.00, balance.getCurrentBalance());
        }
    }

    @Test
    void moneyProvided() {
        Money balance = new Money();
        BigDecimal userInput = new BigDecimal("1");
        BigDecimal result = balance.moneyProvided(userInput);
        assertEquals(new BigDecimal("1.00"), result);
    }

    @Test
    void moneyProvidedNot12510() throws InputMismatchException {
        Money balance = new Money();

        try {
            BigDecimal userInput = new BigDecimal("7");
            BigDecimal result = balance.moneyProvided(userInput);
        } catch (InputMismatchException e){
            return;
        }
        fail();
    }



    @Test
    void testMakeChange() {
        Money balance = new Money();
        balance.moneyProvided(new BigDecimal("5"));
        assertEquals("Your change: " + 20 + " Quarters, " + 0 + " Dimes, " + 0 + " Nickles", balance.makeChange());
    }
}