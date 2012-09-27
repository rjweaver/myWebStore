
package cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.*;
import data.*;

/**
 *
 * @author Rob_Weaver
 */
public class CartServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String productCode = request.getParameter("productCode");
        String quantityString = request.getParameter("quantity");
        String removeButtonValue = request.getParameter("removeButton");
        
        HttpSession session = request.getSession();
        
       // synchronized(session)
        //{
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null)
            {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        
            //quantity value cannot be less than 1
            int quantity = 1;
            try
            {
                quantity = Integer.parseInt(quantityString);
                if(quantity < 0)
                    quantity = 1;
            }
            catch(NumberFormatException nfe)
            {
                quantity = 1;
            }
            
            if(removeButtonValue != null)
            {
                quantity = 0;
            }
            
            //get product from product code
            //Product product = ProductDB.selectProduct(productCode);
/// OLD CODE        
            //ServletContext sc = getServletContext();
            //String path = sc.getRealPath("WEB-INF/products.txt");
            //Product product = ProductIO.getProduct(productCode, path);
        
          Product product = ProductDB.selectProduct(productCode);
          session.setAttribute("product", product);
            
            
            
           if(product != null)    //
           {           //
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if(quantity > 0)
                {
                    cart.addItem(lineItem);
                }
            else if(quantity == 0)
                {
                    cart.removeItem(lineItem);
                }
            }
            
            session.setAttribute("cart", cart);
            
            
        
            String url = "/cart.jsp";
            /*String url = "";
            if(cart.getItems().size() <= 0)
            {
                url = "/index.jsp";
            }
            else
            {
                url = "/cart.jsp";
            }
             * 
             */
             
             
            RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        
        //}  
    }

        
   
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
