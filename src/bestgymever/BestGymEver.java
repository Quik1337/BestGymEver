package bestgymever;

import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class BestGymEver
{
    public BestGymEver() throws IOException, ParseException
    {
        Customer customer = new Customer();
        
        ReadFromFile readFromFile = new ReadFromFile();
        
        RegisterMemberPresence RMP = new RegisterMemberPresence();
        
        boolean flag = false;
        while(!flag)
        {
            try
            {
                String s = JOptionPane.showInputDialog(
                    "[1] Check if customer is a member \n" +
                    "[2] Register customer presence    \n" +
                    "[3] Exit program");

                if (s == null)
                        System.exit(0);

                switch(s)
                {
                    case "1" :

                        s = JOptionPane.showInputDialog(
                            "Search with: Name or IdNum");

                        s = customer.checkIfMember(s);

                        JOptionPane.showMessageDialog(null, s);

                        break;

                    case "2" :

                        s = JOptionPane.showInputDialog(
                            "Register with: Name or IdNum");

                        s = RMP.registerPresence(s);
                        
                        JOptionPane.showMessageDialog(null, s);

                        break;

                    case "3" :

                        System.exit(0);

                        break;

                    default :
                        JOptionPane.showMessageDialog(null,
                            "Choose a number from the menu!");
                }
            }
            
            catch(NullPointerException e)
            {
                System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) throws IOException, ParseException
    {
        BestGymEver bestgymever = new BestGymEver();
    }
}
