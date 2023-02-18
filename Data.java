import java.util.*;
import java.lang.Math;
import java.time.LocalDate;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Data {
    public static ArrayList<String> customer = new ArrayList<String>(); //logged in customer's info
    public static ArrayList<String> ATMarray = new ArrayList<String>(); //atm info
    public static String typeOfAccount = ""; //updates the type of account the user is current in 

    public static void array(String info, int infotype) throws IOException{
        File file = new File("CustomerData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine()) != null){
            String [] values = line.split(",");
            if(values[infotype].equals(info)){
                for(String value: values){
                    customer.add(value);
                }
            }
        }
        br.close();
        fw.close();
    }

    public static void atm(String info, int infotype) throws IOException{
        File file = new File("ATMData.csv"); //describing the file
        FileWriter fw = new FileWriter(file , true);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine()) != null){
            String [] values = line.split(",");
            if(values[infotype].equals(info)){
                for(String value: values){
                    ATMarray.add(value);
                }
            }
        }
        br.close();
        fw.close();
    }
}
