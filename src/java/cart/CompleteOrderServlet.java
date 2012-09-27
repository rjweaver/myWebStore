
package cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import javax.mail.*;
import javax.*;

import business.*;
import data.*;
import util.*;

/**
 *
 * @author Rob_Weaver
 */
public class CompleteOrderServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Invoice invoice = (Invoice)session.getAttribute("invoice");

        String creditCardType = 
                request.getParameter("creditCardType");
        String creditCardNumber = 
                request.getParameter("creditCardNumber");
        String creditCardExpMonth = 
                request.getParameter("creditCardExpirationMonth");
        String creditCardExpYear = 
                request.getParameter("creditCardExpirationYear");

        user.setCreditCardType(creditCardType);
        user.setCreditCardNumber(creditCardNumber);
        user.setCreditCardExpirationDate(creditCardExpMonth
                + "/" + creditCardExpYear);
        
        
        // If a record for the User object exists, update it
        if (UserDB.emailExists(user.getEmailAddress()))
        {
            UserDB.update(user);
        }
        // Otherwise, write a new record for the User object
        else
        {
            UserDB.insert(user);
        }
        
        session.setAttribute("user", user);
        
        // Write a new invoice record
        InvoiceDB.insert(invoice);
        
        // Set the emailCookie in the user's browser.
        Cookie emailCookie = new Cookie("emailCookie",
                user.getEmailAddress());
        emailCookie.setMaxAge(60*24*365*2*60);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);

        // Remove all items from the user's cart
        Cart cart = (Cart) session.getAttribute("cart");
        cart.setItems(new ArrayList<LineItem>());
        
        // Send an email to the user to confirm the order.
        String to = user.getEmailAddress();
        String from = "confirmation@BestWebStore.com";
        String subject = "Order Confirmation";
        String body = "Dear " + user.getFirstName() + ",\n\n" +
            "Thanks for ordering from us. " +
            "You should receive your order in 3-5 business days. " + 
            "Please contact us if you have any questions.\n" +
            "Have a great day and thanks again!\n\n" +
            "Joe King\n" +
            "Fresh Corn Records";
        boolean isBodyHTML = false;
       /*
        try
        {
            MailUtil.sendMail(to, from, subject, body, isBodyHTML);
        }
        catch(MessagingException e)
        {
            this.log(
                "Unable to send email. \n" +
                "You may need to configure your system as " +
                "described in chapter 15. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + to + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
        }
         
         * 
         */
        
        String url = "/complete.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
        
        
    //}

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
