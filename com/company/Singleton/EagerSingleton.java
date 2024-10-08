package com.company.Singleton;

public class EagerSingleton {

    // this will create instance as soon as our project is loaded
    // but this will create overhead of initializing object even if it's not needed

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){
        // initialize properties
    }

    public EagerSingleton getInstance(){
        return instance;
    }

}
