package com.techelevator.framework;

import com.techelevator.framework.Item;

import java.math.BigDecimal;

public class Chip extends Item {
    public static int chipsSold;

    public Chip(String name, String location, BigDecimal price){
        super(name, location, price);
        chipsSold++;
    }

    @Override
    public String playSound(){
        return "Crunch Crunch, Yum!";
    }

}

