package bestgymever;

import java.io.IOException;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

public class BestGymEverIT {
    
    Customer customer = new Customer();
    
    String idNum = "9207191496";
    String name = "Adam Bäckström";
    String memberSince = "2018-07-19";
    
    String x = "";
    String z = "";
    
    @Test
    public void testRegisterPresence() throws IOException, ParseException
    {   
        //Skapar en instans av RegisterMemberPresence
        RegisterMemberPresence RMP = new RegisterMemberPresence();
        
        //Skickar in namn och förväntar mig ett meddelande tillbaka
        x = RMP.registerPresence("adam");
        
        //Skapar en överensstämningsstring
        z = "IdNum: " + idNum + "\n" +
            "Name: "  + name  + "\n" +
            "Precence registered at: 2018-10-19";
        
        assertEquals(z, x);
    }
    
    @Test
    public void testSetCustomer()
    {
        //Skapar upp en customer
        customer.setCustomer(idNum, name, memberSince);
        
        //Testar alla värden
        assertEquals(idNum, customer.getIdNum());
        assertEquals(name, customer.getName());
        assertEquals(memberSince, customer.getMemberSince());
    }
    
    @Test
    public void testCheckIfMember() throws IOException, ParseException
    {
        //Skapar upp en customer
        customer.setCustomer(idNum, name, memberSince);
        
        //Lägger till customern i litan
        customer.customers.add(customer);
        
        //Testar metoden
        x = customer.checkIfMember("adam");
        
        z = "Adam Bäckström is a current member since 2018-07-19";
        
        assertEquals(z, x);
    }
}
