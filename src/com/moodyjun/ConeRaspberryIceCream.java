package com.moodyjun;

public class ConeRaspberryIceCream extends IceCreamCone{
    private String name = "Raspberry (Cone)";
    private Double price = 5.00;

    @Override
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name : " + name + '\n' +
                "Price : " + price + '\n';
    }
}

