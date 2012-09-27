/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.*;

/**
 *
 * @author Rob_Weaver
 */
@WebServlet(name = "DisplayInvoiceServlet", urlPatterns = {"/displayInvoice"})
public class DisplayInvoiceServlet extends HttpServlet 
{

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");       
        Cart cart = (Cart) session.getAttribute("cart");

        java.util.Date today = new java.util.Date();

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setInvoiceDate(today);
        invoice.setLineItems(cart.getItems());
        
        session.setAttribute("invoice", invoice);
        
        String url = "/invoice.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
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
