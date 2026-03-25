import java.io.*;
import java.util.*;

/**
 * Book My Stay Application
 * Data Persistence
 * @version 12.0
 */

class PersistenceService{

    public void save(Map<String,Integer> inventory){

        try{

            ObjectOutputStream out=
            new ObjectOutputStream(
            new FileOutputStream("inventory.dat"));

            out.writeObject(inventory);

            out.close();

            System.out.println("Data Saved");

        }

        catch(Exception e){

            System.out.println("Save Failed");
        }
    }

    public Map<String,Integer> load(){

        try{

            ObjectInputStream in=
            new ObjectInputStream(
            new FileInputStream("inventory.dat"));

            Map<String,Integer> data=
            (Map<String,Integer>)in.readObject();

            in.close();

            System.out.println("Data Restored");

            return data;
        }

        catch(Exception e){

            System.out.println("No previous data found");

            return new HashMap<>();
        }
    }
}

public class DataPersistenceRecovery{

    public static void main(String[] args){

        System.out.println("Book My Stay App v12.0");
        System.out.println();

        PersistenceService service=new PersistenceService();

        Map<String,Integer> inventory=new HashMap<>();

        inventory.put("Single",3);

        service.save(inventory);

        Map<String,Integer> restored=service.load();

        System.out.println("Recovered Inventory");

        for(String room:restored.keySet()){

            System.out.println(room+" : "+restored.get(room));
        }

    }
}