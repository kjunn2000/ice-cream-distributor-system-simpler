package com.moodyjun;

public class BranchManagerHandler {
    public boolean handleRequest(OrderRequest orderRequest){
        if(orderRequest.getTotalAmount() > 10000){
            return false;
        }
        System.out.println("Approved for order request. "+ orderRequest.toString());
        return true;
    }
}
