import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.regex.*;

public class CustomerClass {
    private static String username = "";
    private static String password = "";
    
    public static void options(){ //asks user if they want to login or register
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("1. Login");
            System.out.println("2. Register");
            choice = input.nextInt();
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
                validation = validate();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            threshold++;
        }
        while(validation == false && threshold < 3);
    }

    public static void register() throws IOException{ //register
        Scanner input = new Scanner(System.in);
       
        String newusername ="";
        boolean usernameIsValid = true;
        do{ //checks if username meets the requirements
            System.out.println("Enter a username: "); 
            newusername = input.next();
            usernameIsValid = usernameValidate(newusername); 
        }
        while(usernameIsValid == false);
        System.out.println("Username is valid!");

        String newpassword ="";
        boolean passwordIsValid = true;
        do{ //checks if password meets the requirements
            System.out.print("Enter a password: "); 
            newpassword = input.next();
            passwordIsValid = passwordValidate(newpassword); 
        }
        while(passwordIsValid = false);

        System.out.print("Enter your first name: "); //asks for first name
        String newfirstname = input.next();

        System.out.print("Enter your last name: "); //asks for last name
        String newlastname = input.next();

        System.out.print("Enter your birthday(mm,dd,yy): "); //asks for birthdate
        String newbirthdate = input.next();

        System.out.print("Enter your age: "); //asks for age
        String newage = input.next();

        System.out.print("Enter your social security number: "); //asks for ssn
        String newssn= input.next();

        System.out.print("Enter your email: "); //asks for email
        String newemail = input.next();
    }

    public static boolean validate() throws IOException{
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
        return isValid;
    }

    public static boolean usernameValidate(String newusername) throws IOException{
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

    public static boolean passwordValidate(String newpassword) throws IOException{
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(fr);
        bw.close();
        String line = "";

        if(newpassword.length() < 8){ //checks if password is at least 8 characters
            System.out.println("Password has to be at least 8 characters. Please try a new password.");
            return false;
        }

        if(newpassword.contains(" ")){ //checks if password has a space
            System.out.println("Password cannot contain a space. Please try a new password.");
            return false;
        }

        String regex = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&+=])"
        + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newpassword);
        boolean matchFound = matcher.find();
        System.out.println(matchFound);
        if(matchFound) {
          System.out.println("Match found");
        } else {
          System.out.println("Match not found");
        }



        //String specialChars = "/*!@#$%^&*()\"\\{}_[]|\\?/<>,\\.";
        /* 
        String specialChars = "/*!@#$%^&*(){}[]_.!<>,";
        boolean passwordContainsSpecialChars = true;
        if(newpassword.matches(specialChars)){ //checks if password contains a special character
            passwordContainsSpecialChars = true;
        }
        else{
            System.out.println("Password needs to contain at least one special character. Please try a new password.");
            return false;
        }
        */
        boolean passwordContainsUpperCase = true;
        boolean passwordContainsNumber = true;
        for(int i = 0; i < newpassword.length(); i++){
            if(Character.isUpperCase(newpassword.charAt(i))){ //checks if password contains an uppercase letter
                passwordContainsUpperCase = true;
            }
            else{
                System.out.println("Password needs to contain at least uppercase character. Please try a new password.");
                return false;
            }

            if(Character.isDigit(newpassword.charAt(i))){ //checks if password contains a number
                passwordContainsNumber = true;
            }
            else{
                System.out.println("Password needs to contain at least one number. Please try a new password.");
                return false;
            }

            if(passwordContainsNumber == true && passwordContainsUpperCase == true){
                break;
            }
        }
        return true;
    }
}


class Customer{
    private String username;
    private String password;
    private Long accountnumber;
    private int socialsecurity;
    private String firstname;
    private String lastname;
    private String email;
    private double balance;
    private String creditcardnumber;
    private String creditcardexp;
    private String creditcardcvv;
    private String debitcardnumber;
    private String debitcardexp;
    private String debitcardcvv;
    private String phoneNumber;
    private String pin;
    private int creditScore;
    private int age;
    private String stateOfResidence;
    private String zipCode;

    public Customer(){
        username = "";
        password = "";
        accountnumber = 0L;
        socialsecurity = 0;
        firstname = "";
        lastname = "";
        email = "";
        balance = 0;
        creditcardnumber = "";
        creditcardexp = "";
        creditcardcvv = "";
        debitcardnumber = "";
        debitcardexp = "";
        debitcardcvv = "";
        phoneNumber = "";
        pin = "";
        creditScore = 0;
        age = 0;
        stateOfResidence = "";
        zipCode = "";
    }

    public Customer(String a, String b, Long c, int d, String e, String f, String g, double h, String i, String k, String l, String m, String n, String o, String p, String q, int r, int s, String t, String u){
        username = a;
        password = b;
        accountnumber = c;
        socialsecurity = d;
        firstname = e;
        lastname = f;
        email = g;
        balance = h;
        creditcardnumber = i;
        creditcardexp = k;
        creditcardcvv = l;
        debitcardnumber = m;
        debitcardexp = n;
        debitcardcvv = o;
        phoneNumber = p;
        pin = q;
        creditScore = r;
        age = s;
        stateOfResidence = t;
        zipCode = u;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String a){
        username = a;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String b){
        password = b;
    }
}
