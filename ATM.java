import java.util.*;
import java.io.IOException;


public class ATM {
    public static void access(){
        System.out.println("--------------------");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.println("What type of card will you be using today?");
        do{
            System.out.println("1. Debit");
            System.out.println("2. Credit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            System.out.println("--------------------");
        }
        while(choice < 0 || choice > 2);

        if(choice == 1){
            choice = 1;
        }
        else{
            choice = 4;
        }   

        Boolean cardValid = false;
        String cardnumber = "";
        do{
            System.out.print("Enter you card number: ");
            cardnumber = input.next();
            System.out.println("--------------------");
            cardValid = numberValidate(cardnumber,choice);
        }
        while(cardValid = false);
        
        int threshold = 0;
        boolean Valid = false;
        String pin = "";
        do{
            System.out.print("Enter your pin: ");
            pin = input.next();
            System.out.println("--------------------");
            Valid = Validate(cardnumber, choice, pin, threshold);
            threshold++;
        }
        while(Valid == false && threshold < 4);

        if(Valid == true){
            Transactions.ATM();
        }
    }

    public static boolean numberValidate(String cardnumber, int choice){
        boolean valid = false;
        try {
            Data.atm(cardnumber, choice);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(Data.ATMarray.size() == 0){
            System.out.println("Invalid Card Number! Please try again.");
        }
        else{
            valid = true;
        }
        return valid;
    }

    public static boolean Validate(String cardnumber, int choice, String pin, int threshold){
        if(cardnumber.equals(Data.ATMarray.get(choice)) && pin.equals(Data.ATMarray.get(6))){
            return true;
        }
        else{
            int triesremaining = 3 - threshold; //caluclates tries remaining
            System.out.println("Pin number is wrong! You have " + triesremaining + " try(s) remaining before your card gets suspended!");
            return false;
        }
    }
}
