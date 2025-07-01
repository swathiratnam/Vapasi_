import com.multithreading.TicketBooking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService bookingPool = Executors.newFixedThreadPool(5);

        bookingPool.execute(new TicketBooking("Pooja"));
        bookingPool.execute(new TicketBooking("Varsha"));
        bookingPool.execute(new TicketBooking("Rashmi"));
        bookingPool.execute(new TicketBooking("Pratiba"));
        bookingPool.execute(new TicketBooking("Laitha"));

        bookingPool.shutdown();
    }
}