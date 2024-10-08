package com.company.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingleton2 {

    // using java reflection we can change access modifier of any constructor
    // so using it we can make constructor of Singleton class as public, accessing it to create new objects

    private static void breakSingletonUsingReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructors[] = SerializableSingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);

        SerializableSingleton s1 = SerializableSingleton.getInstance();
        SerializableSingleton s2 = (SerializableSingleton) constructor.newInstance();

        System.out.println("obj1 : "+s1.hashCode());
        System.out.println("obj using reflection : "+s2.hashCode());

    }

    private static void enumSingletonUsingReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructors[] = EnumSingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);

        EnumSingleton s1 = EnumSingleton.INSTANCE;
        EnumSingleton s2 = (EnumSingleton) constructor.newInstance();

        System.out.println("obj1 : "+s1.hashCode());
        System.out.println("obj using reflection : "+s2.hashCode());

    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        breakSingletonUsingReflection();
        enumSingletonUsingReflection();
    }


}
