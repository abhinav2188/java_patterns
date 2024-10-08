package com.company.Concurrency.abstraction;

public abstract class AbstractClass {

    //instance variables

    int defaultVar;
    public int publicVar;
    protected int protectedVar;
    private int privateVar;
    static int staticVar;
    final int finalVar;

    protected AbstractClass(int privateVar, int finalVar) {
        this.privateVar = privateVar;
        this.finalVar = finalVar;
    }

    private AbstractClass(int finalVar){
        this.finalVar = finalVar;
    }

    static AbstractClass getInstance(){
        return new AbstractClass(10) {
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

    // methods
    public abstract void publicAbsMethod();

    protected abstract void protectedAbsMethod();

    abstract void defaultAbsMethod();

    private void privateMethod(){}

    public void publicMethod(){}

    protected void protectedMethod(){}

    void defaultMethod(){}

    static void staticMethod(){}

    final void finalMethod(){}

}
