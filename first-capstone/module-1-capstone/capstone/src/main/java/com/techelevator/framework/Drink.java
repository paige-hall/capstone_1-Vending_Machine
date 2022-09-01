package com.techelevator.framework;

import com.techelevator.framework.Item;

import java.math.BigDecimal;

public class Drink extends Item {
    public static int drinkSold;

    public Drink(String name, String location, BigDecimal price){
        super(name, location, price);
        drinkSold++;
    }

    @Override
    public String playSound(){
        return "Slurp Slurp, Yum!";
    }
}
