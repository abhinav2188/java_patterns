package com.company.ProducerConsumerProblem;

public class SharedResource {
    int instancesCount;
    int emptyCount;
    // int fullCount;

    public SharedResource(int instancesCount){
        this.instancesCount = instancesCount;
        this.emptyCount = instancesCount;
        // this.fullCount = 0; 

    }

    public synchronized void produceItem(){
        if(emptyCount>0){
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                // handle exception
            }
    
            System.out.println("item is produced");
            emptyCount--;
        }else{
            System.out.println("no empty space");
        }
    }

    public synchronized void consumeItem(){
        while(emptyCount == instancesCount
)
        if(emptyCount<instancesCount){
            emptyCount++;
            System.out.println("item is consumed");
        }else{
            System.out.println("all items consumed");
        }
    }


}
