package com.company.Singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    private SerializableSingleton(){}

    private static SerializableSingleton instance;

    public static SerializableSingleton getInstance(){
        if(instance!=null) return instance;
        synchronized (SerializableSingleton.class){
            if(instance == null) instance = new SerializableSingleton();
        }
        return instance;
    }

    // this method is key method called during deserialization process, we simply return the already created object here
//    @Serial
    protected Object readResolve(){
        return instance;
    }

}
