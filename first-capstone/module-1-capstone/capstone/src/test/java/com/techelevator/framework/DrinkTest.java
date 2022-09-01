package com.techelevator.framework;

import org.junit.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @org.junit.jupiter.api.Test
    void playSound() {
        Drink drink = new Drink("Fireball Whiskey", "R1", new BigDecimal("20.95"));
        Assert.assertEquals("Slurp Slurp, Yum!", drink.playSound());
    }

}