package com.moodyjun;

import java.util.*;

public class Client {

    public static SeniorExecutiveHandler seniorExecutiveHandler;
    public static BranchManagerHandler branchManagerHandler;
    public static GeneralManagerHandler generalManagerHandler;
    public static DirectorHandler directorHandler;

    public static void main(String[] args) {
        configureRequestHandler();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu(getType());
            String type = scanner.nextLine();
            if (type.equals("q")) break;

            showMenu(getFlavour());
            String flavour= scanner.nextLine();
            if (flavour.equals("q")) break;
            IceCream iceCream = getIceCream(type, flavour);
            if (Objects.isNull(iceCream)){
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            System.out.print("Enter quantity (default 1, q for exit) : ");
            String input = scanner.nextLine();
            if (input.equals("q")) break;
            int quantity = 1;
            try {
                quantity = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            OrderRequest orderRequest = new OrderRequest(UUID.randomUUID().toString(),
                    iceCream,
                    quantity,
                    quantity * iceCream.getPrice());
            sendRequest(orderRequest);
        }
    }

    private static IceCream getIceCream(String typeInput, String flavourInput){
        switch (typeInput){
            case "Cone":{
                switch (flavourInput){
                    case "Raspberry":{
                        return new ConeRaspberryIceCream();
                    }
                    case "Coffee":{
                        return new ConeCoffeeIceCream();
                    }
                }
            }
            case "Stick":{
                switch (flavourInput){
                    case "Raspberry":{
                        return new StickRaspberryIceCream();
                    }
                    case "Coffee":{
                        return new StickCoffeeIceCream();
                    }
                }
            }
        }
        return null;
    }

    public static void configureRequestHandler() {
        seniorExecutiveHandler = new SeniorExecutiveHandler();
        branchManagerHandler = new BranchManagerHandler();
        generalManagerHandler = new GeneralManagerHandler();
        directorHandler = new DirectorHandler();
    }

    public static String getType(){
        return "1. Cone\n2. Stick\n";
    }

    public static String getFlavour() {
        return "1. Coffee\n2. Rasberry\n";
    }

    public static void showMenu(String input){
        System.out.println("-----------------------------------");
        System.out.println("Menu - [Moody Food]");
        System.out.println(input);
        System.out.println("-----------------------------------");
        System.out.print("Enter choice (q for exit): ");
    }

    public static void sendRequest(OrderRequest orderRequest){
        boolean result ;
        result = seniorExecutiveHandler.handleRequest(orderRequest);
        if (result){
            return;
        }
        result = branchManagerHandler.handleRequest(orderRequest);
        if (result){
            return;
        }
        result = generalManagerHandler.handleRequest(orderRequest);
        if (result){
            return;
        }
        result = directorHandler.handleRequest(orderRequest);
        if (!result)
            System.out.println("Order amount over authorization limit, please contact customer service for assistant.");
    }
}
