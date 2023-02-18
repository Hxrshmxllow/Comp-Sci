import java.util.*;
import java.lang.Math;
import java.time.LocalDate;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test{
    public static void main(String[] args) throws IOException{ //brings user to bank menu
        JFrame frame = new JFrame();
        String[] columnNames = {"Date", "Type", "Amount", "Memo", "Balance"};
        DefaultTableModel statement = new DefaultTableModel(); 
        JTable table = new JTable(statement); 
        statement.addColumn("Date");
        statement.addColumn("Type");
        statement.addColumn("Amount");
        statement.addColumn("Memo");
        statement.addColumn("Balance");
        File file = new File("admin_SavingsTransactions.csv"); //describing the file
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
        }

        br.close();
        fw.close();
        
        frame.add(table);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
        System.out.println("Statement has been opened in a new tab.");
    }
}
