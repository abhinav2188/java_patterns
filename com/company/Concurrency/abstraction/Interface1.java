package com.company.Concurrency.abstraction;

public interface Interface1 {

    // instance vars
    int defaultVar = 10;
    public int publicVar = 10;
//    protected int protectedVar = 20;
//    private int privateVar = 40;
    static int staticVar = 34;
    final int finalVar = 13;

    // here public static final have no use as they are already made public static final internally

    // methods
    private void privateMethod(){}

    public default void publicMethod(){}

//    protected void protectedMethod(){}

//    void defaultMethod(){}

    static void staticMethod(){}

    private void finalMethod(){}

    public abstract void publicAbsMethod();

//    protected abstract void protectedAbsMethod();

    abstract void defaultAbsMethod();


}
