public class CreditCard{
    private static String firstname = Data.customer.get(2);
    private static String lastname = Data.customer.get(2);
    private static String cardName = name();
    private static String creditcardnumber;
    private static String creditcardexp;
    private static String creditcardcvv;

    public static String name(){
        String name = "[" + firstname.charAt(0);
        for(int i = 1; i < firstname.length(); i++){
            name += " " + firstname.charAt(i);
        }
        name += "    ";
        for(int i = 0; i < lastname.length(); i++){
            name += " " + lastname.charAt(i);
        }
        name += "]";
        if(name.length() == 30){
            cardName = name;
        }
        if(name.length() < 30){
            int extrachar = 30 - name.length();
            for(int i = 0; i < extrachar; i++){
                name += ":";
            }
        }
        if(name.length() > 27){
            int excess =  name.length() - 27;
            System.out.println(excess);
            if(excess < 4)
            {
                excess = 3 - excess;
                for(int i = 0; i < excess; i++){
                    name += ":";
                }
            }
            else{
                name = "[" + firstname.charAt(0);
                for(int i = 1; i < firstname.length(); i++){
                name += " " + firstname.charAt(i);
                }
                name += "   ";
                for(int i = 0; i < lastname.length(); i++){
                    name += " " + lastname.charAt(i);
                }
                name += "]";
                excess =  name.length() - 27;
                if(excess < 4)
                {   
                    excess = 3 - excess;
                    for(int i = 0; i < excess; i++){
                        name += ":";
                    }
                }
            }
        }
        return name;
    }

    public static String numbergenerator(user user1, int a){
        String numberstring = "";
        if(numberstring.equals("none")){
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
            if(a == 0){
                user1.setCreditCardNumber(numberstring);
            }
            else{
                user1.setDebitCardNumber(numberstring);
            }
            return numberstring;
        }
        else{
            return numberstring;
        }
    }
    public static String expgenerator(){
        String expstring = "";
        if(a == 0){
            expstring = user1.getCreditCardExp();
        }
        else{
            expstring = user1.getDebitCardExp();
        }
        if(expstring.equals("none")){
            expstring = "";
            int number = (int)(Math.random() * 1) + 0;
            if(number == 0){
                expstring += 0 + " " + ((int)(Math.random() * 8) + 1) + " ";
            }
            else{
                expstring += 1 + ((int)(Math.random() * 2) + 0) + " ";
            }
            number = (int)(Math.random() * 4) + 5;
            expstring += "/ 2 " + number;
            if(a == 0){
                user1.setCreditCardExp(expstring);
            }
            else{
                user1.setDebitCardExp(expstring);
            }
            return expstring;
        }
        else{
            return expstring;
        }
    }
        //Generates CVV if not present
    public static String cvvgenerator(user user1,int a){
        String cvv = "";
        if(a == 0){
            cvv = user1.getCreditCardCvv();
        }
        else{
            cvv = user1.getDebitCardCvv();
        }
        if(cvv.equals("none")){
            cvv = " ";
            for(int i = 0; i < 3; i++){
                int number = (int)(Math.random() * 9);
                cvv += number + " ";
            }
            if(a == 0){  
                user1.setCreditCardCvv(cvv);
            }
            else{
                user1.setDebitCardCvv(cvv);
            }
            return cvv;
        }
        else{
            return cvv;
        }
    }
}