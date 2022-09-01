package com.techelevator.framework;

import java.math.BigDecimal;

public class Item {

    private String productName;
    private String productLocation;
    private BigDecimal price;
    private int amtAvailable = 5;

    /**
     * Building two constructors
     * one an Empty Item constructor
     * the second is loaded constructor that accepts
     * name, location in machine, and price
     */

    public Item(){

    }

    public int buyItem() throws ArithmeticException {
        if(this.amtAvailable == 0){
            System.out.println("Too slow, Try again!");
            throw new ArithmeticException();
        } else {
            return --this.amtAvailable;
        }

    }

    public Item(String productName,
                String productLocation,
                BigDecimal price){
        this.productName = productName;
        this.productLocation = productLocation;
        this.price = price;

    }

    public String getProductName() {
        return productName;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmtAvailable() {
        return amtAvailable;
    }


    public String playSound(){
        return "";
    }
}
