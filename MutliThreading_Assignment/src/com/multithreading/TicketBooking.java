package com.multithreading;

public class TicketBooking implements Runnable {

    public String threadName;

    public TicketBooking(String threadName) {
        this.threadName = threadName;
    }

    public synchronized void booikng() {
        System.out.println(threadName + " booking received.");
    }

    public synchronized void payment() {
        System.out.println(threadName + " payment processed.");
    }

    public synchronized void ticketConformation() {
        System.out.println(threadName + " ticket Confirmed.");
    }

    @Override
    public void run() {

        booikng();
        payment();
        ticketConformation();

    }
}
