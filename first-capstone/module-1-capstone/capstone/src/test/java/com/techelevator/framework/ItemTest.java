package com.techelevator.framework;

import com.techelevator.app.VendingMachine;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void buyItemSoldOut() {
        VendingMachine test = new VendingMachine();
        Money balance = new Money();
        Drink jameson = new Drink("Jameson", "A1", new BigDecimal(0.01));
        jameson.buyItem();
        jameson.buyItem();
        jameson.buyItem();
        jameson.buyItem();
        jameson.buyItem();
        try {
            jameson.buyItem();
        } catch (ArithmeticException e) {
            return;
        }
        fail();
    }




    @Test
    void buyItemSubtractInventory() {
    Item item = new Candy("WarHeads", "B2", new BigDecimal(".50"));

    assertEquals(4, item.buyItem());
    }

}