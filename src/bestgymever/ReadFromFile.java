package bestgymever;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadFromFile
{
    Path inPath = Paths.get("src\\bestgymever\\Customers.txt");
    
    String[] customerInfo;
    String line;
    
    public ReadFromFile() throws FileNotFoundException, IOException
    {
        try(Scanner fileScanner = new Scanner(inPath))
        {
            while(fileScanner.hasNext())
            {   
                line = fileScanner.nextLine();

                customerInfo = line.split(",");
                
                customerInfo[1] = customerInfo[1].trim();
                
                line = fileScanner.nextLine();
                
                Customer customer = new Customer();
                
                customer.setCustomer(customerInfo[0], customerInfo[1], line);
                
                customer.customers.add(customer);
            }
        }
    }
}
