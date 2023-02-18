import java.util.*;
import java.lang.Math;
import java.time.LocalDate;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class SavingsAccount {
    public static void savingsaccountmain(String username){
        Data.typeOfAccount = "Savings";
        username = Data.customer.get(0);
        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.println("--------------------");
        System.out.println("What would you like to see?");
        do{
            System.out.println("1. Display Balance");
            System.out.println("2. Transactions");
            System.out.println("3. Return home.");
            System.out.print("Enter Choice: ");
            choice = input.nextInt();
        }
        while(choice < 0 || choice > 3);
        if(choice == 1){
            System.out.println("--------------------");
            System.out.println("Balance: " + Data.customer.get(11));
            savingsaccountmain(username);
        }
        if(choice == 2){
            try {
                Transactions.statement(1);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(choice == 3){
            BankMain.bankmenu(username);
        }
    }
}
