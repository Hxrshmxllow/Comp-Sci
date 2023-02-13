import java.util.*;
import java.lang.Math;
import java.time.LocalDate;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class GeneralAccount{
    private static String[] data = {}; //stores the logged in customer's data as a string
    public static void generalaccountmain(String username){ //brings user to bank menu
        try {
            data = data(username); //gets the logged in customer's data
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
            savingsaccount();
        }
        if(choice == 2){
            checkingsaccount();
        }
    }

    public static void savingsaccount(){  //savings account
        String savingsaccountnumber = data[9];
        if(savingsaccountnumber.equals("none")){ //if user is new, it will generate new savings account number and update the data file
            savingsaccountnumber = "";
            for(int i = 0; i < 12; i++){
                int number = (int)(Math.random() * 9) + 0;
                savingsaccountnumber += number;
            }
            try {
                dataUpdate(savingsaccountnumber, 1);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //System.out.println("New Number: " + savingsaccountnumber);
    }

    public static void checkingsaccount(){ //checkingsaccount
        try {
            dataUpdate("1289074912874", 2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void transactions() throws IOException{
        File file = new File("Transactions.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
    }

    public static String[] data(String username) throws IOException{ //finds customer info based off username
        String[] customer = {};
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine()) != null)
        {
            String [] values = line.split(",");
            if(values[0].equals(username)){
                customer = values;
            }
        }
        return customer;
    }

    public static void dataUpdate(String info, int type) throws IOException{ //updates data; type 1 = savings account and type 2 = checkings account
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        if(type == 1){ //checks if savings account number needs to be updated
            data[9] = info;
            bw.newLine();
            for(String str: data){
                bw.write(str + ",");
            }

        }
        if(type == 2){ //checks if checkings account number needs to be updated
            System.out.println("Checkings"); 
        }
    }
}
