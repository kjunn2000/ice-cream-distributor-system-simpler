package com.moodyjun;

public class StickRaspberryIceCream extends IceCreamCone{
    private final String name = "Raspberry (Stick)";
    private final Double price = 6.00;

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
