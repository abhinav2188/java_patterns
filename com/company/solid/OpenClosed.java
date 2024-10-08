package com.company.solid;

public class OpenClosed {

    // classes/interfaces should be open for extension and closed for modifications

    static class Calculator{

        Integer calculate(int a, int b, String operation){
            return switch (operation) {
                case "add" -> a + b;
                case "subtract" -> a - b;
                default -> null;
            };
        }

        // violates open closed principle if we want to add new operations

    }

    ///------------------------

    // we will create a interface Operation which can be implemented by diff operations.. object of this interface will
    // be passed in the calculator

    interface Operation{
        Integer calculate(int a, int b);
    }

    static class Addition implements Operation{

        @Override
        public Integer calculate(int a, int b) {
            return a+b;
        }
    }

    static class Subtraction implements Operation{

        @Override
        public Integer calculate(int a, int b) {
            return a-b;
        }
    }

    static class Calculator2{

        Integer calculate(int a, int b, Operation operation){
            return operation.calculate(a,b);
        }

    }

    public static void main(String args[]){

        Calculator2 calculator2 = new Calculator2();
        System.out.println(calculator2.calculate(10,14,new Addition()));
        System.out.println(calculator2.calculate(10,14,new Subtraction()));

    }

}
