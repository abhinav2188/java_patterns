package com.company.locks.Reenterent;

import java.util.concurrent.locks.ReentrantLock;

public class Main {


    // when we have mulitple threads having multiple objects but need a shared resource to be accessed by a single
    // thread

    public static void main(String[] args) {

        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(()->{
            resource1.produce(lock);
        });
        Thread t2 = new Thread(()->{
            resource2.produce(lock);
        });

        t1.start();
        t2.start();

    }

}
