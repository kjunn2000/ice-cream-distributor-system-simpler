package com.moodyjun;

public class VicePresidentHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 100000){
            return false;
        }
        System.out.println("\nOrder is under RM100,000-> Approved \n" + orderRequest);
        return true;
    }
}
