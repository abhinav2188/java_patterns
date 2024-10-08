package com.company.locks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private int data;

    public SharedResource(int data){
        this.data = data;
    }

    public void reader(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("read lock acquired by: "+Thread.currentThread().getName());
            System.out.println("data value read: "+data);
            Thread.sleep(4000);
        }catch (Exception e){
            // exception handling
        }
        finally {
            System.out.println("read lock released by: "+Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void writer(ReadWriteLock lock, int data){
        try{
            lock.writeLock().lock();
            System.out.println("write lock acquired by: "+Thread.currentThread().getName());
            this.data = data;
            System.out.println("updated data: "+this.data);
            Thread.sleep(4000);
        }catch (Exception e){
            // handle exception
        }
        finally {
            System.out.println("write lock released by: "+Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }

}
