package com.techelevator.framework;

import com.techelevator.framework.Item;

import java.math.BigDecimal;

public class Gum extends Item {

    private static int gumSold;

    public Gum(String name, String location, BigDecimal price){
        super(name, location, price);
        gumSold++;
    }

    @Override
    public String playSound(){
        return "Chew Chew, Yum!";
    }
}
