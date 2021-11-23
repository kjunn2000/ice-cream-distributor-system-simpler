package com.moodyjun;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static List<IceCream> iceCreamList;
    public static BranchManagerHandler branchManagerHandler;
    public static RegionalDirectorHandler regionalDirectorHandler;
    public static VicePresidentHandler vicePresidentHandler;
    public static PresidentHandler presidentHandler;

    public static List<IceCream> getIceCreamList() {
        return List.of(new ConeRaspberryIceCream(), new ConeCoffeeIceCream(), new StickRaspberryIceCream(), new StickCoffeeIceCream());
    }

    public static void configureRequestHandler() {
        branchManagerHandler = new BranchManagerHandler();
        regionalDirectorHandler = new RegionalDirectorHandler();
        vicePresidentHandler = new VicePresidentHandler();
        presidentHandler = new PresidentHandler();
    }

    public static void main(String[] args) {
        iceCreamList = getIceCreamList();
        configureRequestHandler();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Menu - [Moody Food]");
            iceCreamList.forEach(System.out::println);
            System.out.println("-----------------------------------");
            System.out.print("Enter ice cream name (q for exit): ");
            String input = scanner.nextLine();
            if (input.equals("q")) break;
            IceCream iceCream = null;
            try {
                String finalInput = input;
                Optional<IceCream> item = iceCreamList.stream().filter(i -> i.getName().equals(finalInput)).findFirst();
                if (item.isEmpty()) {
                    throw new Exception();
                }
                iceCream = item.get();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            System.out.print("Enter quantity (default 1, q for exit) : ");
            input = scanner.nextLine();
            if (input.equals("q")) break;
            int quantity = 1;
            try {
                quantity = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            OrderRequest orderRequest = new OrderRequest(UUID.randomUUID().toString(), iceCream, quantity, quantity * iceCream.getPrice());
            sendRequest(orderRequest);
        }

    }

    public static void sendRequest(OrderRequest orderRequest){
        boolean result = false;
        result = branchManagerHandler.handleRequest(orderRequest);
        if (result){
            return;
        }
        result = regionalDirectorHandler.handleRequest(orderRequest);
        if (result){
            return;
        }
        result = vicePresidentHandler.handleRequest(orderRequest);
        if (result){
            return;
        }
        result = presidentHandler.handleRequest(orderRequest);
        if (!result)
            System.out.println("Order amount over 300,000, please contact customer service for assistant.");
    }
}
