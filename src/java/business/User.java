/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author Rob_Weaver
 */
public class User implements Serializable{
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String creditCardType;
    private String creditCardNumber;
    private String creditCardExpirationDate;
    
    public User()
    {
        firstName = "";
        lastName = "";
        emailAddress = "";
        address = "";
        city = "";
        state = "";
        zipCode = "";
        country = "";
        creditCardType = "";
        creditCardNumber = "";
        creditCardExpirationDate = "";
        
    
    }
    
    public User(String firstName, String lastName, String emailAddress,  String address,
           String city, String state, String zipCode, String country, String creditCardType,
           String creditCardNumber, String creditCardExpirationDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.creditCardType = creditCardType;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpirationDate = creditCardExpirationDate;
        
    }
    
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
      public String getLastName()
    {
        return lastName;
    }
    
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress; 
    }
    
     public String getEmailAddress()
    {
        return emailAddress; 
    }
     
     public void setAddress(String address)
     {
         this.address = address;
     }
     
     public String getAddress()
     {
         return address;
     }
     public void setCity(String city)
     {
         this.city = city;
     }
     
     public String getCity()
     {
         return city;
     }
     public void setState(String state)
     {
         this.state = state;
     }
     
     public String getState()
     {
         return state;
     }
     public void setZipCode(String zipCode)
     {
         this.zipCode = zipCode;
     }
     
     public String getZipCode()
     {
         return zipCode;
     }
     public void setCountry(String country)
     {
         this.country = country;
     }
     
     public String getCountry()
     {
         return country;
     }
     
      public void setCreditCardType(String creditCardType)
    {
        this.creditCardType = creditCardType;
    }
    
    public String getCreditCardType()
    {
        return creditCardType;
    }
    
     public void setCreditCardNumber(String creditCardNumber)
    {
        this.creditCardNumber = creditCardNumber;
    }
    
    public String getCreditCardNumber()
    {
        return creditCardNumber;
    }
    
     public void setCreditCardExpirationDate(String creditCardExpirationDate)
    {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }
    
    public String getCreditCardExpirationDate()
    {
        return creditCardExpirationDate;
    }
}
