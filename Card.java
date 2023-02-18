public class Card {
    public static String numbergenerator(){
        String numberstring = "";
        numberstring = "";
        for(int i = 0; i < 4; i++){
            int number = (int)(Math.random() * 9) + 0;
            numberstring += number + " ";
        }
        numberstring+= "   ";
        for(int i = 0; i < 4; i++){
            int number = (int)(Math.random() * 9) + 0;
            numberstring += number + " ";
        }
        numberstring+= "   ";
        for(int i = 0; i < 4; i++){
            int number = (int)(Math.random() * 9) + 0;
            numberstring += number + " ";
        }
        numberstring+= "   ";
        for(int i = 0; i < 3; i++){
            int number = (int)(Math.random() * 9) + 0;
            numberstring += number + " ";
        }
        int number = (int)(Math.random() * 9) + 0;
        numberstring += number;
        return numberstring;
    }

    public static String expdategenerator(){
        String expstring = "";
        int number = (int)(Math.random() * 1) + 0;
        if(number == 0){
            expstring += 0 + " " + ((int)(Math.random() * 8) + 1) + " ";
        }
        else{
            expstring += 1 + ((int)(Math.random() * 2) + 0) + " ";
        }
        number = (int)(Math.random() * 4) + 5;
        expstring += "/ 2 " + number;
        return expstring;
    }

    public static String cvvgenerator(){
        String cvv = "";
        for(int i = 0; i < 3; i++){
            int number = (int)(Math.random() * 9);
            cvv += number + " ";
        }
        return cvv;  
    }

    public static void  card(user user1, String name, String creditcardnumber, String creditcardexp, String creditcardcvv){
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
                System.out.println("|:::[" + creditcardnumber + "]:::::::::::::|");
            }
            if(i == 11){
                System.out.println("|:::::::::::::::::::::::::::::::::::[EXPIRES]:[" + creditcardexp + "]::|");
            }
            if(i == 12){
                System.out.println("|:::" + name + "::[END]::::::::::::::::::|");
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
                System.out.println("|                                          |::::|" + creditcardcvv + "|::|");
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to return home");
        System.out.println("Press 2 to sign out");
        int choice = input.nextInt();
        if(choice == 1){
            variables(user1);
        }
        else if(choice == 2){
            return;
        }
    }
}
