package com.company.Singleton;

import java.io.*;

public class BreakSingleton1 {

    // --------------------------------breaking singleton 1 -----------------------------------------//
    // real world example
    // suppose in distributed systems across multiple nodes and servers, we want to access a singleton object
    // at time of a node restart we need to store the object in a file and then retrieve it to access the same object
    // this will lead to different instances

    static void breakSingletonUsingSerialization() throws IOException, ClassNotFoundException {

        SynchronizedSingleton s1 = SynchronizedSingleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        objectOutputStream.writeObject(s1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singleton.obj"));
        SynchronizedSingleton s2 = (SynchronizedSingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("serialized obj : "+s1.hashCode());
        System.out.println("deserialized obj : "+s2.hashCode());

    }

    static void singletonUsingSerialization() throws IOException, ClassNotFoundException {

        SerializableSingleton s1 = SerializableSingleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        objectOutputStream.writeObject(s1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singleton.obj"));
        SerializableSingleton s2 = (SerializableSingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("serialized obj : "+s1.hashCode());
        System.out.println("deserialized obj : "+s2.hashCode());

    }

    static void enumSingletonSerialization() throws IOException, ClassNotFoundException {

        EnumSingleton s1 = EnumSingleton.INSTANCE;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        objectOutputStream.writeObject(s1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singleton.obj"));
        EnumSingleton s2 = (EnumSingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("serialized obj : "+s1.hashCode());
        System.out.println("deserialized obj : "+s2.hashCode());

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        breakSingletonUsingSerialization();
        singletonUsingSerialization();
        enumSingletonSerialization();
    }

}
