<%-- 
    Document   : cart
    Created on : Aug 20, 2012, 9:49:19 PM
    Author     : Rob_Weaver
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--<%@include file="/includes/header.html" %> -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cart</title>
        
        <style type="text/css">
           
            body{background-color:lightgrey; }
            table{background-color: white; padding: 5px;}
            
        </style>
        
        
    </head>
    <body>
        <h1>Your Cart</h1>
        
        
        <table cellspacing="5" border="0">
            <tr>
                <th align="left">Quantity</th>
                <th align="left">Description</th>
                <th align="left">Price</th>
                <th align="left">Amount</th>
            </tr>
            
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <c:forEach var="item" items="${cart.items}">
  <form action="<c:url value='/cart' />" method="post">
  <tr valign="top">
    <td>
        <input type="hidden" name="productCode" value="${item.product.code}">
        <input type="text" size="2" name="quantity" value="${item.quantity}">
        <input type="submit" value="Update">
    </td>
    <td>${item.product.description}</td>
    <td>${item.product.priceCurrencyFormat}</td>
    <td>${item.totalCurrencyFormat}</td>
    <td><input type="submit" name="removeButton" value="Remove"></td>
  </tr>
  </form>
  </c:forEach>
        
            <tr>
                <td colspan="3">
                    <p><b>To change the quantity for an item</b>, enter the new
                    quantity and click the Update button.</p>
                    <p><b>To remove an item</b>, click the Remove button.</p>
                </td>
            </tr>
        </table>
        </form>
        
        <%@taglib prefix="r" uri="/WEB-INF/tlds/webApp.tld" %>
        
        <p>The current Date is <r:currentDate />.</p>
        <br>
        
        <!-- Continue Shopping Button --> 
        <form action="<c:url value='/index.jsp'/>" method="post">
            <input type="submit" name="continue"value="Continue Shopping">
        </form>
            
            <br>
            
        <form action="<c:url value='/checkUser'/>" method="post">
            <input type="submit" name="checkout" value="Checkout">
            </form>
            <br>
        
             <%@include file="/includes/footer.jsp" %> 
    </body>
</html>
