package com.company.locks.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    private int a=10;

    public void readAndUpdate(StampedLock lock){
        try{
            long stamp = lock.tryOptimisticRead();
            System.out.println("optimistic read by by: "+Thread.currentThread().getName());
            Thread.sleep(4000);

            a = 12;
            if(lock.validate(stamp)){
                write(lock);
            }else{
                System.out.println("rollback by: "+Thread.currentThread().getName());
            }

        }catch (Exception e){
            // exception handling
        }

    }

    public void write(StampedLock lock){

        long stamp = lock.writeLock();
        System.out.println("write lock acquired by: "+Thread.currentThread().getName());

        lock.unlockWrite(stamp);
        System.out.println("write lock released by: "+Thread.currentThread().getName());

    }

}
