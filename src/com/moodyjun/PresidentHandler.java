package com.moodyjun;

public class PresidentHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 300000){
            return false;
        }
        System.out.println("Approved for order request. "+ orderRequest.toString());
        return true;
    }
}
