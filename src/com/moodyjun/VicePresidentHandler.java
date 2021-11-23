package com.moodyjun;

public class VicePresidentHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 100000){
            return false;
        }
        System.out.println("Approved for order request. "+ orderRequest.toString());
        return true;
    }
}
