import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;

public class BankMain {
    public static void bankmenu(String username){
        try {
            Data.array(username ,0);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Data.atm(username ,0);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Data.customer);
        System.out.println("--------------------");
        System.out.println("Welcome, " + username + "!");
        System.out.println("--------------------");
        System.out.println("Where would you like to go?");
        int choice = 0;
        Scanner input = new Scanner(System.in); //asks user where to go
        do{
            System.out.println("1. Savings Account");
            System.out.println("2. Checkings Account");
            System.out.print("Enter Your Choice: ");
            choice = input.nextInt();
        }
        while(choice < 0 && choice > 3);
        System.out.println("--------------------");
        if(choice == 1){
            SavingsAccount.savingsaccountmain(username);
        }
        if(choice == 2){
            CheckingsAccount.checkingsaccountmain(username);
        }
    }
}
