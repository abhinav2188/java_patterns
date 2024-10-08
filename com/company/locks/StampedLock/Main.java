package com.company.locks.StampedLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class Main {


    // when we have mulitple threads having multiple objects but need a shared resource to be accessed by a single
    // thread

    public static void main(String[] args) {

        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();

        StampedLock lock = new StampedLock();

        Thread t1 = new Thread(()->{
            resource1.readAndUpdate(lock);
        });
        Thread t2 = new Thread(()->{
            resource2.write(lock);
        });

        t1.start();
        t2.start();

    }

}
