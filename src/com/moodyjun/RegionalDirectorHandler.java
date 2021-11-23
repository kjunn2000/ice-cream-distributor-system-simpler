package com.moodyjun;

public class RegionalDirectorHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 50000){
            return false;
        }
        System.out.println("Approved for order request. "+ orderRequest.toString());
        return true;
    }
}
