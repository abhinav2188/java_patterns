package com.company.locks.Reenterent;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private boolean isProduced;

    public void produce(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("lock accquired by: "+Thread.currentThread());
            isProduced = true;
            Thread.sleep(4000);
        }catch (Exception e){
            // exception handling
        }
        finally {
            lock.unlock();
            System.out.println("lock released by: "+Thread.currentThread());
        }
    }

}
