import java.util.*;

/**
 * Book My Stay Application
 * Add-On Service Selection
 * @version 7.0
 */

class AddOnService{

    String serviceName;
    int cost;

    public AddOnService(String serviceName,int cost){

        this.serviceName=serviceName;
        this.cost=cost;
    }
}

class AddOnServiceManager{

    private Map<String,List<AddOnService>> services=new HashMap<>();

    public void addService(String reservationId,AddOnService service){

        services.putIfAbsent(reservationId,new ArrayList<>());

        services.get(reservationId).add(service);
    }

    public int calculateCost(String reservationId){

        int total=0;

        if(services.containsKey(reservationId)){

            for(AddOnService s:services.get(reservationId)){

                total+=s.cost;
            }
        }

        return total;
    }

    public void displayServices(String reservationId){

        System.out.println("Services for Reservation "+reservationId);

        if(services.containsKey(reservationId)){

            for(AddOnService s:services.get(reservationId)){

                System.out.println(s.serviceName+" : "+s.cost);
            }
        }
    }
}

public class AddOnServiceSelection{

    public static void main(String[] args){

        System.out.println("Book My Stay App v7.0");
        System.out.println();

        AddOnServiceManager manager=new AddOnServiceManager();

        manager.addService("R101",new AddOnService("Breakfast",500));
        manager.addService("R101",new AddOnService("Airport Pickup",800));

        manager.displayServices("R101");

        System.out.println("Total Add-On Cost : "+manager.calculateCost("R101"));

    }
}