/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;
import javax.servlet.*;
import java.util.*;

import business.*;
import data.*;

/**
 *
 * @author Rob_Weaver
 */
public class CartContextListener implements ServletContextListener
{
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext sc = event.getServletContext();      
 
        // initialize the customer service email address that's used throughout the web site
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);

        // initialize the current year that's used in the copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);
        
        // initialize the path for the products text file
        String productsPath = sc.getRealPath("WEB-INF/products.txt");
        sc.setAttribute("productsPath", productsPath);
        
        // initialize the list of products
        ArrayList<Product> products = new ArrayList<Product>();      
        products = ProductIO.getProducts(productsPath);
        sc.setAttribute("products", products);
    }
    
    public void contextDestroyed(ServletContextEvent event)
    {
        // no cleanup necessary
    }    
}