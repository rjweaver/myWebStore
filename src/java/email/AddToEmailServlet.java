
package email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.*;
import data.*; 
import data.UserDB;

/**
 *
 * @author Rob_Weaver
 */
public class AddToEmailServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         //getting parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String country = request.getParameter("country");
        
        
        User user = new User();
        //session.setAttribute("user", user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        user.setAddress(address);
        user.setCity(city);
        user.setState(state);
        user.setZipCode(zipCode);
        user.setCountry(country);
        
        
        HttpSession session = request.getSession();
        
        String message = "";
        String url = "";
        
        //check that email address doesn't already exist
        if (UserDB.emailExists(emailAddress))
        {
            message = "This email address already exists. <br>"
                    + "Please enter another email address.";
            session.setAttribute("message", message);
            url = "/join_email.jsp";
        }
        else
        {
            UserDB.insert(user);
            message = "";
            session.setAttribute("message", message);
            url = "/disp_info.jsp";
        }
        
        //HttpSession session = request.getSession();
        session.setAttribute("user", user);
        request.setAttribute("message", message);
          
        
  
        
        //forward request and response objects to JSP
        //String url = "/disp_info.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
        //COOKIES deletes all persistent cookies
        Cookie emailCookie = new Cookie("emailCookie", emailAddress);
            emailCookie.setMaxAge(60*60*24*365*1); // age 1 year
            emailCookie.setPath("/"); //allow for the entire application
            response.addCookie(emailCookie);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
