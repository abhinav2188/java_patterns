package com.company.solid;

public class Liskov {

    // child classes must be substitutable of their parent class

    interface Loan{
        void getCredit();
        void repayLoan();
        void collateral();
    }

    static class HomeLoan implements Loan{

        @Override
        public void getCredit() {

        }

        @Override
        public void repayLoan() {

        }

        @Override
        public void collateral() {

        }
    }

    static class CreditCardLoan implements  Loan{

        @Override
        public void getCredit() {

        }

        @Override
        public void repayLoan() {

        }

        @Override
        public void collateral() {
            // no collateral is present in credit card loans
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        Loan loan1 = new HomeLoan();
        Loan loan2 = new CreditCardLoan();

        loan1.collateral(); // works fine
        loan2.collateral(); // will throw exception -- violates liskov principle
    }


}
