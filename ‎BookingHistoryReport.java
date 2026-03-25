import java.util.*;

/**
 * Book My Stay Application
 * Booking History Reporting
 * @version 8.0
 */

class Reservation{

    String guest;
    String room;

    public Reservation(String guest,String room){

        this.guest=guest;
        this.room=room;
    }
}

class BookingHistory{

    private List<Reservation> history=new ArrayList<>();

    public void addReservation(Reservation r){

        history.add(r);
    }

    public List<Reservation> getHistory(){

        return history;
    }
}

class ReportService{

    public void generateReport(BookingHistory history){

        System.out.println("Booking History Report");

        for(Reservation r:history.getHistory()){

            System.out.println(r.guest+" booked "+r.room);
        }
    }
}

public class BookingHistoryReport{

    public static void main(String[] args){

        System.out.println("Book My Stay App v8.0");
        System.out.println();

        BookingHistory history=new BookingHistory();

        history.addReservation(new Reservation("Azam","Single"));
        history.addReservation(new Reservation("Madhav","Suite"));

        ReportService report=new ReportService();

        report.generateReport(history);

    }
}