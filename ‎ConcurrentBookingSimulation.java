import java.util.*;

/**
 * Book My Stay Application
 * Concurrent Booking Simulation
 * @version 11.0
 */

class BookingProcessor{

    private int rooms=2;

    public synchronized void book(String guest){

        if(rooms>0){

            System.out.println(guest+" booked room");

            rooms--;
        }

        else{

            System.out.println(guest+" failed booking");
        }
    }
}

class GuestThread extends Thread{

    BookingProcessor processor;
    String name;

    public GuestThread(BookingProcessor p,String name){

        processor=p;

        this.name=name;
    }

    public void run(){

        processor.book(name);
    }
}

public class ConcurrentBookingSimulation{

    public static void main(String[] args){

        System.out.println("Book My Stay App v11.0");
        System.out.println();

        BookingProcessor processor=new BookingProcessor();

        GuestThread g1=new GuestThread(processor,"Azam");
        GuestThread g2=new GuestThread(processor,"Madhav");
        GuestThread g3=new GuestThread(processor,"Soumya");

        g1.start();
        g2.start();
        g3.start();

    }
}