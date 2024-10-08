package com.company.locks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {


    // when we have mulitple threads having multiple objects but need a shared resource to be accessed by a single
    // thread

    public static void main(String[] args) {

        SharedResource resource1 = new SharedResource(10);
        SharedResource resource2 = new SharedResource(23);

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(()->{
            resource1.reader(lock);
        });
        Thread t4 = new Thread(()->{
            resource2.writer(lock,10);
        });
        Thread t2 = new Thread(()->{
            resource2.reader(lock);
        });
        Thread t3= new Thread(()->{
            resource1.reader(lock);
        });

        t4.start();
        t1.start();
        t2.start();
        t3.start();

    }

}
