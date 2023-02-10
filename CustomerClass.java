import java.util.Scanner;
import java.util.ArrayList;

public class CustomerClass {
    private static ArrayList<Customer> array = new ArrayList<Customer>();
    
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
            register();
        }
    }

    public static void login(){ //login 
        boolean validation = false;
        int threshold = 0;
        do{
            Scanner input = new Scanner(System.in);
            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();
            validation = validation(username, password);
            threshold++;
           // System.out.println("Validation: " +validation + " threshold: " +threshold);
        }
        while(validation == false || threshold > 3);
        
        System.out.println("Validation: " +validation + " threshold: " +threshold);

    }

    public static void register(){ //register

    }

    public static boolean validation(String userName, String password){
        if(array.size() == 0)
            customerdata();
        boolean isValid = false;  
        for(int i = 0; i < array.size(); i++) {   
            //System.out.println(array.get(i).getUsername() +" " +userName);
            //System.out.println(array.get(i).getPassword() +" " +password);
            isValid = (array.get(i).getUsername().equals(userName) && (array.get(i).getPassword().equals(password)));
            
            //System.out.println(isValid);
            if(isValid == true)
                break;
        } 
        return isValid;
    }

    public static void customerdata(){
        Customer customer1 = new Customer("admin", "user", 478912738988L, 124789798, "Harshit", "Patel", "example@gmail.com", 1000000.0, "none", "none", "none", "none", "none", "none", "732-934-4378", "6235", 700, 30, "NJ", "08857");
        Customer customer2 = new Customer("test", "user", 478912738988L, 124789798, "Harshit", "Patel", "example@gmail.com", 1000000.0, "none", "none", "none", "none", "none", "none", "732-934-4378", "6235", 700, 30, "NJ", "08857");
        
        array.add(customer1);
        array.add(customer2);
        
        
        //System.out.println(array.get(0).getUsername());
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
