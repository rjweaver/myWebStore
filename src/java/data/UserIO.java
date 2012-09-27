
package data;

import java.io.*;
import business.User;
/**
 *
 * @author Rob_Weaver
 */
public class UserIO {
    
    public static void add(User user, String filepath)throws IOException
    {
        File file = new File(filepath);
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.println(user.getEmailAddress()+ "|"
                + user.getFirstName()+ "|"
                + user.getLastName()+ "|"
                + user.getAddress()+ "|"
                + user.getCity()+ "|"
                + user.getState()+ "|"
                + user.getZipCode()+ "|"
                + user.getCountry()+ "|"
                + user.getCreditCardNumber()+ "|"
                + user.getCreditCardType()+ "|"
                + user.getCreditCardExpirationDate());
        out.close();
    }
    
    public static void getUser()throws IOException
    {

   // String emailAddress = user.getEmailAddress();
    }
}
