package data;

/**
 *
 * @author Rob_Weaver
 */
import java.sql.*;

import business.*;

public class UserDB
{
    public static int insert(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method adds a new record to the Users table in the database
        String query = 
                "INSERT INTO User (FirstName, LastName, EmailAddress, " + 
                "Address, City, State, ZipCode, Country, CreditCardType, " +
                "CreditCardNumber, CreditCardExpirationDate ) " +
                "VALUES (?, ?, ?, ?, " +
                "?, ?, ?, ?, " +
                "?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmailAddress());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getCity());
            ps.setString(6, user.getState());
            ps.setString(7, user.getZipCode());
            ps.setString(8, user.getCountry());
            ps.setString(9, user.getCreditCardType());
            ps.setString(10, user.getCreditCardNumber());
            ps.setString(11, user.getCreditCardExpirationDate());
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //This method updates the record with a matching email address.
        //It returns a value of 0 if the email address can't be found.
        String query = "UPDATE User SET " +
                "FirstName = ?, " +
                "LastName = ?, " +
                "Address = ?, " +
                "City = ?, " +
                "State = ?, " +
                "ZipCode = ?, " +
                "Country = ?, " +
                "CreditCardType = ?, " +
                "CreditCardNumber = ?, " +
                "CreditCardExpirationDate = ?, " +
                "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());  
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getCity());
            ps.setString(5, user.getState());
            ps.setString(6, user.getZipCode());
            ps.setString(7, user.getCountry());
            ps.setString(8, user.getCreditCardType());
            ps.setString(9, user.getCreditCardNumber());
            ps.setString(10, user.getCreditCardExpirationDate());
            ps.setString(11, user.getEmailAddress());

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static boolean emailExists(String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT EmailAddress FROM User " +
                "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int selectUserID(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //This method returns 0 if invoiceID isn't found.
        String query = "SELECT UserID FROM User " +
                "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmailAddress());
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt("UserID");
            else
                return -1;
        }
        catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    

    //This method returns null if a record isn't found.
    public static User selectUser(String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM User " +
                       "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next())
            {
                user = new User();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmailAddress(rs.getString("EmailAddress"));  
                user.setAddress(rs.getString("Address"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZipCode(rs.getString("ZipCode"));
                user.setCountry(rs.getString("Country"));
                //user.setCreditCardType(rs.getString("CreditCardType"));
                //user.setCreditCardNumber(rs.getString("CreditCardNumber"));
                //user.setCreditCardExpirationDate(rs.getString("CreditCardExpirationDate"));
            }
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}