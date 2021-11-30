package com.moodyjun;

public class StickCoffeeIceCream extends IceCreamStick{
    private String name = "Coffee (Stick)";
    private Double price = 6.00;

    @Override
    public String getName() {
        return name;
    }

    public Double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Name : " + name + '\n' +
                "Price : " + price + '\n';
    }
}
