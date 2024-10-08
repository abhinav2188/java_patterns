package com.company.solid;

public class DependencyInversion {

    // top level objects should not be dependent upon low level classes i.e.
    // classes should be dependent upon abstractions instead of actual implementations

    // example
    // in a shopping mall parking space, we have a algorithm which dependent upon time and type of vehicle parked
    // the price of ticket is calculated

    class TicketProcessor{
        int processTicket(Ticket ticket){
            return 0;
        }
    }

    class Ticket{
        long entryTime;
        long exitTime;
        String vehicleType;
    }

    class ParkingLot{
        TicketProcessor ticketProcessor;

        ParkingLot(){
            ticketProcessor= new TicketProcessor();
        }
        int getTicketCost(Ticket ticket){
            return ticketProcessor.processTicket(ticket);
        }

        // this violated DIP as we are relying on TicketProcessor class, creating its object
    }

    // --------------DIP

    interface TicketProcessorInterface{
        int processTicket(Ticket ticket);
    }

    class TicketProcessor1 implements TicketProcessorInterface{

        @Override
        public int processTicket(Ticket ticket) {
            return 0;
        }
    }

    class ParkingLot1{
        TicketProcessorInterface ticketProcessorInterface;
        ParkingLot1(TicketProcessorInterface ticketProcessorInterface){
            this.ticketProcessorInterface = ticketProcessorInterface;
        }
        int getTicketCost(Ticket ticket){
            return ticketProcessorInterface.processTicket(ticket);
        }
    }

    // now if we want to change the implementation of ticket processor we can create a new class implementation and
    // give it in the constructor of parkingLot1





}
