import java.util.Scanner;

public class CreditCard{
    public static void main(String[] args){
        user user1 = new user("admin", "user", 123456, 123098, "John", "Doe", "Male", 99, "idontexist@gmail.com", 100000.00); //created a sample user for testing purposes
        Scanner input = new Scanner(System.in);
        System.out.println("1: Credit Card"); //asks the user if they need credit or debit card
        System.out.println("2: Debit Card");
        int choice = input.nextInt();
        if(choice == 1){
            creditcard(user1);
        }
        if(choice == 2){
            debitcard(user1);
        }
    }

    public static void creditcard(user user1){ //prints credit card front and back
        for(int i = 0; i < 14; i++){
            if(i == 0 || i == 3 || i == 4 || i == 8 || i == 10 || i == 13){
                System.out.println("|::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            }
            if(i == 1){
                System.out.println("|:::[ B A N K   O F ]:::::::::::::::::::::[ C R E D I T ]::|");
            }
            if(i == 2){
                System.out.println("|:::[ V I T O   C A N G E R I Z Z I ]:::::::::[ C A R D ]::|");
            }
            if(i == 5 || i == 6){
                System.out.println("|:::|########|:::::::::::::::::::::::::::::::::::::|####|::|");
            }
            if(i == 7){
                System.out.println("|:::|########|:::::::::::::::::::::::::::::::::::::::::::::|");
            }
            if(i == 9){
                System.out.println("|:::[1 2 3 4    5 6 7 8    9 1 0 1    2 1 3 1]:::::::::::::|");
            }
            if(i == 11){
                System.out.println("|:::::::::::::::::::::::::::::::::::[EXPIRES]:[0 3 / 1 2]::|");
            }
            if(i == 12){
                System.out.println("|:::[J o h n    D    S m i t h]:::::[END]::::::::::::::::::|");
            }
        }

        for(int j = 0; j < 4; j++){
            System.out.println("");
        }

        for(int k = 0; k < 14; k++){
            if(k == 0 || k == 4 || k == 5 || k == 8 || k == 9 || k == 10 || k == 11 || k == 12){
                System.out.println("|::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            }
            if(k == 1 || k == 2 || k == 3){
                System.out.println("|NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN|");
            }
            if(k == 6){
                System.out.println("|                                          |::::| C V V |::|");
            }
            if(k == 7){
                System.out.println("|                                          |::::| 9 8 8 |::|");
            }
        }
        Scanner input = new Scanner(System.in);  //asks user to return back or sign out 
        System.out.println("Press 1 to return home");
        System.out.println("Press 2 to sign out");
        int choice = input.nextInt();
        if(choice == 1){
            main(null);
        }
        else if(choice == 2){
            return;
        }
    }

    public static void debitcard(user user1){ //prints debit card front and back
        for(int i = 0; i < 14; i++){
            if(i == 0 || i == 3 || i == 4 || i == 8 || i == 10 || i == 13){
                System.out.println("|::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            }
            if(i == 1){
                System.out.println("|:::[ B A N K   O F ]:::::::::::::::::::::::[ D E B I T ]::|");
            }
            if(i == 2){
                System.out.println("|:::[ V I T O   C A N G E R I Z Z I ]:::::::::[ C A R D ]::|");
            }
            if(i == 5 || i == 6){
                System.out.println("|:::|########|:::::::::::::::::::::::::::::::::::::|####|::|");
            }
            if(i == 7){
                System.out.println("|:::|########|:::::::::::::::::::::::::::::::::::::::::::::|");
            }
            if(i == 9){
                System.out.println("|:::[1 2 3 4    5 6 7 8    9 1 0 1    2 1 3 1]:::::::::::::|");
            }
            if(i == 11){
                System.out.println("|:::::::::::::::::::::::::::::::::::[EXPIRES]:[0 3 / 1 2]::|");
            }
            if(i == 12){
                System.out.println("|:::[J o h n    D    S m i t h]:::::[END]::::::::::::::::::|");
            }
        }

        for(int j = 0; j < 4; j++){
            System.out.println("");
        }

        for(int k = 0; k < 14; k++){
            if(k == 0 || k == 4 || k == 5 || k == 8 || k == 9 || k == 10 || k == 11 || k == 12){
                System.out.println("|::::::::::::::::::::::::::::::::::::::::::::::::::::::::::|");
            }
            if(k == 1 || k == 2 || k == 3){
                System.out.println("|NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN|");
            }
            if(k == 6){
                System.out.println("|                                          |::::| C V V |::|");
            }
            if(k == 7){
                System.out.println("|                                          |::::| 9 8 8 |::|");
            }
        }
        Scanner input = new Scanner(System.in); //asks user to return back or sign out 
        System.out.println("Press 1 to return home");
        System.out.println("Press 2 to sign out");
        int choice = input.nextInt();
        if(choice == 1){
            main(null);
        }
        else if(choice == 2){
            return;
        }
    }
}

class user{ //object class
    private String username;
    private String password;
    private int accountnumber;
    private int socialsecurity;
    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private String email;
    private double balance;

    public user(){
        username = "";
        password = "";
        accountnumber = 0;
        socialsecurity = 0;
        firstname = "";
        lastname = "";
        gender = "";
        age = 0;
        email = "";
        balance = 0;
    }

    public user(String a, String b, int c, int d, String e, String f, String g, int h, String i, double j){
        username = a;
        password = b;
        accountnumber = c;
        socialsecurity = d;
        firstname = e;
        lastname = f;
        gender = g;
        age = h;
        email = i;
        balance = j;
    }
}
