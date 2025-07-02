package com.multithreading;

import java.util.logging.Logger;

public class TicketBooking implements Runnable {
    private static final Logger logger = Logger.getLogger(TicketBooking.class.getName());

    public String threadName;

    public TicketBooking(String threadName) {
        this.threadName = threadName;
    }

    public synchronized void booikng() {
        logger.info(threadName + " booking received.");
    }

    public synchronized void payment() {
        logger.info(threadName + " payment processed.");
    }

    public synchronized void ticketConformation() {
        logger.info(threadName + " ticket Confirmed.");
    }

    @Override
    public void run() {
        booikng();
        payment();
        ticketConformation();

    }
}
