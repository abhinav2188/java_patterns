package com.company.locks.SemaphoreLock;

import java.util.concurrent.Semaphore;


public class SharedResource {

    private int a=10;

    private Semaphore lock = new Semaphore(2);

    public void produce(){
        try{
            lock.acquire();
            System.out.println("lock acquired by: "+Thread.currentThread().getName());
            Thread.sleep(4000);
        }catch (Exception e){
            // exception handling
        }
        finally {
            System.out.println("lock released by: "+Thread.currentThread().getName());
            lock.release();
        }
    }

}
