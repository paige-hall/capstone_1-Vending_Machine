package com.techelevator.framework;

import org.junit.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ChipTest {
    @org.junit.jupiter.api.Test
    void playSound() {
        Chip chip = new Chip("XXtra Hot Cheetos", "R1", new BigDecimal("3.95"));
        Assert.assertEquals("Crunch Crunch, Yum!", chip.playSound());
    }

}