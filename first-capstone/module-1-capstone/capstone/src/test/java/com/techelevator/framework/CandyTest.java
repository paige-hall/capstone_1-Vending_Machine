package com.techelevator.framework;

import org.junit.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    @org.junit.jupiter.api.Test
    void playSound() {
        Candy candy = new Candy("Hersey's Bar", "R1", new BigDecimal("3.95"));
        Assert.assertEquals("Munch Munch, Yum!", candy.playSound());
    }
}