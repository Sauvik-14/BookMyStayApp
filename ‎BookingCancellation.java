import java.util.*;

/**
 * Book My Stay Application
 * Booking Cancellation
 * @version 10.0
 */

class CancellationService{

    private Map<String,Integer> inventory=new HashMap<>();

    private Stack<String> releasedRooms=new Stack<>();

    public CancellationService(){

        inventory.put("Single",1);
    }

    public void cancel(String reservation,String room){

        releasedRooms.push(reservation);

        inventory.put(room,inventory.getOrDefault(room,0)+1);

        System.out.println("Cancelled Reservation "+reservation);

        System.out.println("Inventory Restored");
    }
}

public class BookingCancellation{

    public static void main(String[] args){

        System.out.println("Book My Stay App v10.0");
        System.out.println();

        CancellationService service=new CancellationService();

        service.cancel("R101","Single");

    }
}