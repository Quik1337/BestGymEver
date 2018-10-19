package bestgymever;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class Customer
{
 //Variabler
    
    public static List<Customer> customers = new ArrayList<>();
    
    private String idNum;
    private String name;
    private String memberSince;
    
    private String[] nameFirstLast;
    
 //Setters
    
    public void setIdNum(String idNum)
    {
        this.idNum = idNum;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public void setMemberSince(String memberSince)
    {   
        this.memberSince = memberSince;
    }
    
    public void setCustomer(String idNum, String name, String memberSince)
    {  
        setIdNum(idNum);
        setName(name);
        setMemberSince(memberSince);
    }
    
 //Getters
    
    public String getIdNum()
    {
        return this.idNum;
    }
    
    public String getName() 
    {
        return this.name;
    }
    
    public String getMemberSince()
    {
        return this.memberSince;
    }
    
 //Metod
    
    public String checkIfMember(String s) throws ParseException
    {   
        //Går igenom alla customers i listan
        for (Customer c : customers)
        {   
            //Delar upp för- och efternamn
            nameFirstLast = c.getName().split(" ");
            nameFirstLast[1] = nameFirstLast[1].trim();
            
            //Om input överensstämmer med för-/efternamn eller idnummer
            if(s.equalsIgnoreCase(c.getName()) ||
                    
                s.equalsIgnoreCase(nameFirstLast[0]) ||
                s.equalsIgnoreCase(nameFirstLast[1]) ||
                    
                s.equals(c.getIdNum()))
            {
                    //Här parsar jag ett stringvärde till ett datum!
                    LocalDate memberSinceLD = LocalDate.parse(c.getMemberSince());
                
                    //Om customern har betalat sin avgift inom spannet av ett år.
                    if(LocalDate.now().minusYears(1).isBefore(memberSinceLD))
                    
                        return c.getName() + " is a current member since " + c.getMemberSince();
                
                    //Om customern INTE har betalat sin avgift inom spannet av ett år,
                    //men är en tidigare registrerad customer.
                    else if(LocalDate.now().minusYears(1).isAfter(memberSinceLD))
                        
                        return c.getName() + " is a former member. \n" + 
                               "Last payment was at " + c.getMemberSince();
            }
        }
        
        //Om customern inte är registrarad.           
        return "The customer you are searching for has has never been here before. \n" +
               "Please try again!";
    }
}