package com.company.Singleton;

public class LazySingleton {

        // instance is created when getInstance() is called for the first time
        // not thread safe more than one instance can be created by threads

        private static LazySingleton instance;

        private LazySingleton(){
        }

        public static LazySingleton getInstance(){
            if(instance == null){
                instance = new LazySingleton();
            }
            return instance;
        }

}
