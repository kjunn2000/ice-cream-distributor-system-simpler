package com.moodyjun;

public class BranchManagerHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 50000){
            return false;
        }
        System.out.println("\nOrder is under RM50,000-> Approved \n" + orderRequest);
        return true;
    }
}
