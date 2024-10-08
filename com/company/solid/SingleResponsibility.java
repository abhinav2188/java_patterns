package com.company.solid;

public class SingleResponsibility {

    interface Baker{
        void bakeBread();
        void distributeBread();
        // violates single responsibility principle
    }

    interface  Baker2{
        void bakeBread();
    }

    interface Distributor{
        void distributeBread();
    }

    // ----------------------------------ex2

    interface Account{
        void createAccount();
        void updateAccount();
        void deposit();
        void withdraw();
    }

    interface Account2{
        void createAccount();
        void updateAccount();
    }

    interface  AccountTransactions{
        void deposit();
        void withdraw();
    }

}
