package com.company.locks.SemaphoreLock;

import java.util.concurrent.locks.StampedLock;

public class Main {


    // when we have mulitple threads having multiple objects but need a shared resource to be accessed by a single
    // thread

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::produce);
        Thread t2 = new Thread(()->{
            resource.produce();
        });
        Thread t3 = new Thread(()->{
            resource.produce();
        });
        Thread t4 = new Thread(()->{
            resource.produce();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
