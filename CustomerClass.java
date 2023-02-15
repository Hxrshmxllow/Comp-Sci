import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.regex.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class CustomerClass extends BankMain{
    private static String username = "";
    private static String password = "";
    
    public static void options(){ //asks user if they want to login or register
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Enter Your Choice: ");
            choice = input.nextInt();
            System.out.println("--------------------");
        }
        while(choice < 1 || choice > 2);
        if(choice == 1){ 
            login();
        }
        else if(choice == 2){
            try {
                register();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        input.close();
    }

    public static void login(){ //login 
        boolean validation = false;
        int threshold = 0;
        do{
            Scanner input = new Scanner(System.in);
            System.out.print("Username: ");
            username = input.next();
            System.out.print("Password: ");
            password = input.next();
            try {
                validation = validate(threshold);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            threshold++;
        }
        while(validation == false && threshold < 4);
        if(threshold == 4){
            System.out.println("You have too many failed attempts, please wait a few seconds and try again.");
            System.out.println("--------------------");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            options();
        }
        if(validation == true){
            bankmenu(username);
        }
    }

    public static void register() throws IOException{ //register
        Scanner input = new Scanner(System.in);
       
        String newusername ="";
        boolean usernameIsValid = true;
        do{ //checks if username meets the requirements
            System.out.print("Enter a username: "); 
            newusername = input.next();
            usernameIsValid = usernameValidate(newusername); 
        }
        while(usernameIsValid == false);
        System.out.println("Username is valid!");
        System.out.println("--------------------");

        String newpassword ="";
        boolean passwordIsValid = true;
        do{ //checks if password meets the requirements
            System.out.print("Enter a password: "); 
            newpassword = input.next();
            passwordIsValid = passwordValidate(newpassword);
        }
        while(passwordIsValid == false);
        System.out.println("Password is valid!");
        System.out.println("--------------------");

        System.out.print("Enter your first name: "); //asks for first name
        String newfirstname = input.next();
        System.out.println("--------------------");

        System.out.print("Enter your last name: "); //asks for last name
        String newlastname = input.next();
        System.out.println("--------------------");

        System.out.print("Enter your birthday(mm/dd/yyyy): "); //asks for birthdate
        String newbirthdate = input.next();
        System.out.println("--------------------");

        System.out.print("Enter your age: "); //asks for age
        String newage = input.next();
        System.out.println("--------------------");

        System.out.print("Enter your social security number: "); //asks for ssn
        String newssn= input.next();
        System.out.println("--------------------");

        System.out.print("Enter your email: "); //asks for email
        String newemail = input.next();
        System.out.println("--------------------");

        System.out.print("Enter your state of residency(abbreviation): "); //asks for state of residency
        String newSOR = input.next();
        System.out.println("--------------------");

        System.out.println("Please make sure your information is correct."); //prints out registration info
        System.out.println("Username: " + newusername);
        System.out.println("Password: " + newpassword);
        System.out.println("First Name: " + newfirstname);
        System.out.println("Last Name: " + newlastname);
        System.out.println("Birthday: " + newbirthdate);
        System.out.println("Age: " + newage);
        System.out.println("Social Security Number: " + newssn);
        System.out.println("Email: " + newemail);
        System.out.println("State of Residency: " + newSOR);
        System.out.println("--------------------");
        String savingsaccountnumber = "";
        for(int i = 0; i < 12; i++){
            int number = (int)(Math.random() * 9) + 0;
            savingsaccountnumber += number;
        }
        String checkingsaccountnumber = "";
        for(int i = 0; i < 12; i++){
            int number = (int)(Math.random() * 9) + 0;
            checkingsaccountnumber += number;
        }
        System.out.println("Registering your details...");
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        bw.newLine(); 
        bw.write(newusername + ","); //adds customer details to database
        bw.write(newpassword + ",");
        bw.write(newfirstname + ",");
        bw.write(newlastname + ",");
        bw.write(newbirthdate + ",");
        bw.write(newage + ",");
        bw.write(newssn + ",");
        bw.write(newemail + ",");
        bw.write(newusername + ",");
        bw.write(newSOR + ",");
        bw.write(savingsaccountnumber + ",");
        bw.write(checkingsaccountnumber + ",");
        bw.write("100.00");
        bw.close();
        System.out.println("Account successfully created. Welcome, " + newfirstname + "!");
        System.out.println("As a reward of registering with the Bank of Vito Cangerizzi, we have deposited a $100.00 to you savings account!");
        System.out.println("Redirecting you to login...");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("--------------------");
        options();

    }

    public static boolean validate(int threshold) throws IOException{ //validates username and password
        boolean isValid = false;  
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        bw.close();
        String line = "";
        while((line = br.readLine()) != null) //reading file
        {
            String [] values = line.split(",");
            if(username.equals(values[0]) && password.equals(values[1])){ //checks for match
                isValid = true;
                break;
            }
        }
        if(isValid == false){
            int triesremaining = 3 - threshold; //caluclates tries remaining
            System.out.println("Username and Password do not match! You have " + triesremaining + " try(s) remaining!");
        }
        return isValid;
    }

    public static boolean usernameValidate(String newusername) throws IOException{ //checks if username is valid
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        bw.close();
        String line = "";

        //boolean usernameExists = false;
        while((line = br.readLine()) != null) //checks if username already exists
        {
            String [] values = line.split(",");
            if(newusername.equals(values[0])){
                System.out.println("Username is already taken! Please try another username.");
                //usernameExists = true;
                return false;
            }
        }

        //boolean usernameLengthIsValid = true;
        if(newusername.length() < 8 || newusername.length() > 24){ //checks username length is between 8 and 24 characters
            System.out.println("Username has to be between 8 and 24 characters. Please try another username");
            return false;
        }

        boolean usernameContainsSpecialCharacters = false; 
        for(int i = 0; i < newusername.length(); i++){ //checks if username contains special characters 
            if(!Character.isDigit(newusername.charAt(i)) && !Character.isLetter(newusername.charAt(i))){
                System.out.println("Username cannot contain special charcters. Please try another username");
                return false;
            }
        }
        return true;
    }

    public static boolean passwordValidate(String newpassword) throws IOException{ //checks is password is valid
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        bw.close();
        String line = "";
        boolean passwordIsValid = true;

        if(newpassword.length()>=8){ //first checks if password is 8 characters long
            Pattern lowercaseletter = Pattern.compile("[a-z]"); //defines lowercase letters
            Pattern uppercaseletter = Pattern.compile("[A-z]"); //defines upper letters
            Pattern digit = Pattern.compile("[0-9]"); //defines all numbers for 0-9
            Pattern special = Pattern.compile("[!@#$%&*()_=+|<>?{}\\[\\]~-]"); //defines all special characters

            Matcher hasLowerCaseLetter = lowercaseletter.matcher(newpassword); //looks for lowercase 
            Matcher hasUpperCaseLetter = uppercaseletter.matcher(newpassword); //looks for uppercase
            Matcher hasDigit = digit.matcher(newpassword); //looks for number 
            Matcher hasSpecial = special.matcher(newpassword);//looks for special chracter 

            boolean LowerCaseletterFind = hasLowerCaseLetter.find(); //converts to boolean
            boolean UpperCaseletterFind = hasUpperCaseLetter.find(); //converts to boolean
            boolean digitFind = hasDigit.find(); //converts to boolean
            boolean specialFind = hasSpecial.find(); //converts to boolean

            if(LowerCaseletterFind == false){ //if password is missing lowerletter
                System.out.println("Password has to contain at least one uppercase and lowercase letter. Please try again.");
                passwordIsValid = false;
            }
            if(UpperCaseletterFind == false){ //if password is uppercase letter
                System.out.println("Password has to contain at least one uppercase and lowercase letter. Please try again.");
                passwordIsValid = false;
            }
            if(digitFind == false){ //if password is missing a number
                System.out.println("Password has to contain at least one number. Please try again.");
                passwordIsValid = false;
            }
            if(specialFind == false){ //if password is special character
                System.out.println("Password has to contain at least one special character. Please try again.");
                passwordIsValid = false;
            }
        }
        else{
            System.out.println("Password has to be at least 8 characters long. Please try again."); //if password is not 8 characters long, it returns false
            passwordIsValid = false;
        }
        return passwordIsValid;
    }
}
