package com.company.ProducerConsumerProblem;

public class Main {
    
    // problem -- we have a space with n capacity
    // at a time either item can be produced or it can be consumed
    // a producer can produce an item only when there is empty space
    // a consumer can consume item if one of the space is filled

    public static void main(String[] args) {
        
        SharedResource sharedResource = new SharedResource(5);

        Thread producer = new Thread(()->{
            sharedResource.produceItem();
        });

        Thread consumer = new Thread(()->{
            sharedResource.consumeItem();
        });
    


    
    }



}
