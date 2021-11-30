package com.moodyjun;

public class DirectorHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 300000){
            return false;
        }
        System.out.println("\nOrder is under RM300,000-> Approved \n" + orderRequest);
        return true;
    }
}
