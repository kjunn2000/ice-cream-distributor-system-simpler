package com.moodyjun;

public class SeniorExecutiveHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 10000){
            return false;
        }
        System.out.println("\nOrder is under RM10,000-> Approved \n" + orderRequest);
        return true;
    }
}
