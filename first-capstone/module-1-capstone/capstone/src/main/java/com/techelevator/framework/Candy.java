package com.techelevator.framework;

import com.techelevator.framework.Item;

import java.math.BigDecimal;

public class Candy extends Item {

    public static int candySold;

    public Candy(String name, String location, BigDecimal price){
        super(name, location, price);
        candySold++;
    }

    @Override
    public String playSound(){
        return "Munch Munch, Yum!";
    }

}
