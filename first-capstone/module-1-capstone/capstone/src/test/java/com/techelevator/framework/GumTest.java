package com.techelevator.framework;

import org.junit.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GumTest {
    @org.junit.jupiter.api.Test
    void playSound() {
        Gum gum = new Gum("Bazooka", "R1", new BigDecimal("0.05"));
        Assert.assertEquals("Chew Chew, Yum!", gum.playSound());
    }

}