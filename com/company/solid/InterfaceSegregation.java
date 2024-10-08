package com.company.solid;

public class InterfaceSegregation {

    // a subclass which is implementing an interface should not be forced to implement methods it doesn't require

    // functions that a user can do in ecomm site
    interface User{
        void viewCatalogue();
        void viewCart();
        void viewUpcomingItems();
        void addProducts();
        // this interface includes all functions that a user can do be it customer_user, seller_user, premium_customer_user
        // violating interface segregation
    }

    interface User1{
        // common functions
        void viewCatalogue();
        void viewCart();
    }

    interface Premium_Customer{
        void viewUpcomingItems();
    }

    interface Seller{
        void addProducts();
    }


}
