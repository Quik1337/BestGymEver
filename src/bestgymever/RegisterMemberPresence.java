package bestgymever;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;

public class RegisterMemberPresence
{
    Path outPath = Paths.get("src\\bestgymever\\TrainingRecord.txt");
    
    Customer customer = new Customer();
    
    private String[] nameFirstLast;
    
    public String registerPresence(String s) throws IOException
    {
        try(PrintWriter printToFile = new PrintWriter(Files.newBufferedWriter
        (outPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)))
        {
            for (Customer c : customer.customers)
            {   
                nameFirstLast = c.getName().split(" ");
                nameFirstLast[1] = nameFirstLast[1].trim();

                if(s.equalsIgnoreCase(c.getName()) ||
                   s.equalsIgnoreCase(nameFirstLast[0]) ||
                   s.equalsIgnoreCase(nameFirstLast[1]) ||
                   s.equals(c.getIdNum()))   
                {
                    LocalDate memberSince = LocalDate.parse(c.getMemberSince());

                    if(LocalDate.now().minusYears(1).isBefore(memberSince))
                    {
                        //Skriver till fil
                        printToFile.println(
                            "IdNum: " + c.getIdNum() + "\r\n" +
                            "Name: " + c.getName() + "\r\n" +
                            "Precence registered at: " + LocalDate.now() +
                            System.lineSeparator());
                        
                        printToFile.close();
                        
                        return "IdNum: " + c.getIdNum() + "\n" +
                               "Name: " + c.getName() + "\n" +
                               "Precence registered at: " + LocalDate.now();
                    }

                    else if(LocalDate.now().minusYears(1).isAfter(memberSince))

                        return c.getName() + " is a former member. \n" + 
                               "Last payment was at " + c.getMemberSince();
                }
            }

            return "The customer has has never been here before!";
        }
    }
}
