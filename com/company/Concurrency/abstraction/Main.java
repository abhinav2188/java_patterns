package com.company.Concurrency.abstraction;

public class Main {

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass(10,20) {
            @Override
            public void publicAbsMethod() {

            }

            @Override
            protected void protectedAbsMethod() {

            }

            @Override
            void defaultAbsMethod() {

            }
        };
    }
}
