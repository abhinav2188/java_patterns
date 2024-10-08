package com.company.Singleton;

import java.io.Serializable;

public class SynchronizedSingleton implements Serializable {

    private SynchronizedSingleton(){}

    private static SynchronizedSingleton instance;

    public static SynchronizedSingleton getInstance(){
        if(instance!=null) return instance;
        synchronized (SynchronizedSingleton.class){
            if(instance == null) instance = new SynchronizedSingleton();
        }
        return instance;
    }

    // this solves the problem of threadsafe and unwanted initialization
    // but still there are ways in which singleton can be broken i.e. ways in which we can have different instances
    // or we will allow new instance to be created
}
