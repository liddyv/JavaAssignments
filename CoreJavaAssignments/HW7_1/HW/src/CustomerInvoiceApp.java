

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/*  
 * @HomeWork #7-1: CustomerInvoiceApp.java
 * @Author: WanLing Hsieh
 * @Description: 
 * This app read db, join table using sql and display required data
 */
public class CustomerInvoiceApp {

    private static Connection connection;

    public static void main(String args[]) {        
        // open connection
        try {
        	  String dbUrl = "jdbc:derby:BineetDB";
            connection = DriverManager.getConnection(dbUrl);        
        } catch (SQLException e) {
            System.err.println(e);
            return;
        }        
        
        // select data from database
        printCustomerInvoice();

        // close connection
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);            
        }
    }

    public static void printCustomerInvoice() {
    	String selectStatement = 
    			"SELECT c.EmailAddress, InvoiceNumber, InvoiceDate, InvoiceTotal "
    			+ "FROM Customers as c "
    			+ "JOIN invoices as i "
    			+ "ON c.CustomerID = i.CustomerID "
    			+ "ORDER BY c.EMAILADDRESS ASC";
    	
        try (Statement statement = connection.createStatement();
        	ResultSet rs = statement.executeQuery(selectStatement)) 
        {	
        	System.out.println("Welcome to the Customer Invoices Report");
        	System.out.println();
            while (rs.next()) {
                String emailAddress = rs.getString("EmailAddress");
                String invoiceNumber = rs.getString("InvoiceNumber");
                Date invoiceDate = rs.getDate("InvoiceDate");
                double invoiceTotal = rs.getDouble("InvoiceTotal");
                
                // format the Data
                DateFormat df = new SimpleDateFormat("MM/dd/YY");
                String customerInvoiceString = 
                StringUtil.padWithSpaces(emailAddress, 30)
                + StringUtil.padWithSpaces(invoiceNumber, 10)
                + StringUtil.padWithSpaces(df.format(invoiceDate), 10)
                + StringUtil.padWithSpaces(getFormattedPrice(invoiceTotal), 10);
                
                System.out.println(customerInvoiceString);
  
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static String getFormattedPrice(double invoiceTotal) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(invoiceTotal);
    }

    
}