
package cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import business.*;
import data.*;

/**
 *
 * @author Rob_Weaver
 */
public class DisplayCartServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String quantityString = request.getParameter("quantity");
        String productCode = request.getParameter("productCode");
        String removeButtonValue = request.getParameter("removeButton");

        HttpSession session = request.getSession();
        
        Cart cart = (Cart) session.getAttribute("cart");  
        if (cart == null)
        {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // If the user enters a negative or invalid number in the
        // Update text box, the quantity is automatically reset to 1.
        int quantity = 1;
        try
        {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0)
                quantity = 1;
        }
        catch(NumberFormatException nfe)
        {
            quantity = 1;
        }

        // If the user clicks the Remove button
        if (removeButtonValue != null)
        {
            quantity = 0;
        }

        // Get product from product code
        Product product = ProductDB.selectProduct(productCode);
        session.setAttribute("product", product);

        // If product exists, add or remove from cart
        if (product != null)
        {
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0)
                cart.addItem(lineItem);
            else
                cart.removeItem(lineItem);
        }
        session.setAttribute("cart", cart);
        
        // If no items exist in cart, forward to the Quick Order page.
        // Otherwise, forward to the Cart page.
        String url = "";
        if (cart.getItems().size() <= 0)
        {
            url = "/products";  //products
        }
        else
        {
            url = "/cart.jsp";
        }

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
