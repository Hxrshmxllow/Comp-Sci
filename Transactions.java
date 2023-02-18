import java.util.*;
import java.lang.Math;
import java.time.LocalDate;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.text.SimpleDateFormat; 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Transactions {
    public static void ATM(){
        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.println("Select an Account");
        do{
            System.out.println("1. Savings Account");
            System.out.println("2. Checkings Account");
            System.out.println("3. Sign Out");
            System.out.print("Enter Choice: ");
            choice = input.nextInt();
        }
        while(choice < 0 || choice > 3); 
        if(choice == 1){
            Data.typeOfAccount = "Savings";  //updates type of account if user picked savings
            try {
                transactions();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if(choice == 2){
            Data.typeOfAccount = "Checkings"; //updates type of account if user picked checkings
            try {
                transactions();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            UserMenu.main(null); //brings user to bank menu/home
        }
    }

    public static void transactions() throws IOException{
        String username = Data.customer.get(0); //gets username from array
        String amount = "";
        String memo = "";
        
        Scanner input = new Scanner(System.in);
        int typeOfTransaction = 0;
        System.out.println("--------------------");
        System.out.println("What would you like to do?");
        do{
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Sign Out.");
            System.out.print("Enter Choice: ");
            typeOfTransaction = input.nextInt();
        }
        while(typeOfTransaction < 0 || typeOfTransaction > 3);


        if(typeOfTransaction == 1){
            System.out.println("--------------------");
            System.out.println("How much would you like to deposit?");
            System.out.print("$");
            amount = input.next();
            memo = "ATM Deposit";
        }
        else if(typeOfTransaction == 2){
            System.out.println("--------------------");
            System.out.println("How much would you like to withdraw?");
            System.out.print("$");
            amount = input.next();
            memo = "ATM Withdrawl";
        }
        else{
            UserMenu.main(null);
        }

        System.out.println("Please wait while we process this...");
        
        double amt = Double.parseDouble(amount);

        String filename = username + "_" + Data.typeOfAccount + "Transactions.csv"; //names csv file based on username
        File file = new File(filename); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        double balance = 0.00;
        if (br.readLine() == null) {
            balance = Double.parseDouble(Data.customer.get(11)); //gets balance from array if they have an empty transactions history
        }
        else{
            while((line = br.readLine()) != null){ //gets last balance of transaction history
                String [] values = line.split(",");
                balance = Double.parseDouble(values[4]);
            }
            bw.newLine();
        }
        
        String transactiontype = "";
        if(typeOfTransaction == 1){ //gets balance after deposit
            transactiontype = "Deposit";
            balance = balance + amt; 
            System.out.println(balance);
        }
        else if(typeOfTransaction == 2){//gets balance after withdrawl
            transactiontype = "Withdrawl";
            balance = balance - amt; 
        }
        else if(typeOfTransaction == 3){//gets balance after transfer
            transactiontype = "Transfer";
            balance = balance - amt; 
        }

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formatteddate = dateFormat.format(today);
        System.out.println(formatteddate);

        bw.write(formatteddate + ",");
        bw.write(transactiontype + ",");
        bw.write(amount + ",");
        bw.write(memo + ",");
        bw.write(balance + "");
        bw.close();
        System.out.println("Successful!");
        System.out.println("--------------------");

        amount = String.valueOf(balance);
        Data.customer.remove(11);
        Data.customer.set(11, amount);

        
        ATM();
    }

    public static void statement(int typeOfAccount) throws IOException{
        String filename = Data.customer.get(0) + "_" + Data.typeOfAccount + "Transactions.csv"; //names csv file based on username
        JFrame frame = new JFrame();
        DefaultTableModel statement = new DefaultTableModel(); 
        JTable table = new JTable(statement); 
        statement.addColumn("Date");
        statement.addColumn("Type");
        statement.addColumn("Amount");
        statement.addColumn("Memo");
        statement.addColumn("Balance");
        File file = new File(filename); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String date = "";
        String type = "";
        String amount = "";
        String memo = "";
        String balance = "";
        while((line = br.readLine()) != null){
            String [] values = line.split(",");
            date = values[0];
            type = values[1];
            amount = values[2];
            memo = values[3];
            balance = values[4];
            statement.addRow(new Object[] {date,type,amount,memo,balance});
            statement.addRow(new Object[] {""});
        }
        br.close();
        fw.close();
        
        frame.add(table);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
        System.out.println("Statement has been opened in a new tab.");

        if((Data.typeOfAccount).equals("Savings")){ //checks where this class was called from and brings user back to that class
            SavingsAccount.savingsaccountmain(null);
        }
        else{
            CheckingsAccount.checkingsaccountmain(null);
        }
    }
}
