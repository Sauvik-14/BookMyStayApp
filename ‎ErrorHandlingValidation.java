import java.util.*;

/**
 * Book My Stay Application
 * Error Handling and Validation
 * @version 9.0
 */

class InvalidBookingException extends Exception{

    public InvalidBookingException(String msg){

        super(msg);
    }
}

class Validator{

    private Map<String,Integer> inventory=new HashMap<>();

    public Validator(){

        inventory.put("Single",2);
        inventory.put("Double",1);
    }

    public void validate(String room) throws InvalidBookingException{

        if(!inventory.containsKey(room)){

            throw new InvalidBookingException("Invalid Room Type");
        }

        if(inventory.get(room)<=0){

            throw new InvalidBookingException("Room Not Available");
        }

        inventory.put(room,inventory.get(room)-1);

        System.out.println("Booking Validated");
    }
}

public class ErrorHandlingValidation{

    public static void main(String[] args){

        System.out.println("Book My Stay App v9.0");
        System.out.println();

        Validator v=new Validator();

        try{

            v.validate("Suite");

        }

        catch(Exception e){

            System.out.println("Error : "+e.getMessage());
        }

    }
}