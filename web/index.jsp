<%-- 
    Document   : index
    Created on : Aug 20, 2012, 12:46:09 PM
    Author     : Rob_Weaver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--<%@include file="/includes/header.html" %>-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store</title>
        
         <!-- CSS page style customization -->
        <style type="text/css">
            h1{font-size:28px; }
            h2{font-size:24px; }
            h3{font-size:16px; color:red;}
            body{background-color:cornflowerblue; }
            table{background-color: white;}
            
        </style>
        
    </head>
    <body>
        
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
        
        <h1>Welcome to our Store!</h1>  
        
        <p>Here at BestDeals Music we have all the sounds you need!</p>
        
        <table cellpadding="5" border="1">
     
            <tr valign="top">
                <td align="left"><b>Description</b></td>
                <td align="left"><b>Price</b></td>
                <td align="left"></td>
            </tr>
            
            <c:forEach var="product" items="${applicationScope.products}">
            <tr valign="top">
                <td>${product.description}</td>
                <td>${product.priceCurrencyFormat}</td>
                <td><a id="store" href="<c:url value='/cart?productCode=${product.code}' />">
                    Add To Cart</a></td>
            </tr>
            </c:forEach>     
           
        </table>
                        
       <p><b>Note</b>: All Prices listed are final. Deals and coupons are updated daily<br>
       so prices may vary depending on when you visit this site.</p>
                        
                                         
        
                        <br> <!-- Just used to make the page longer for footer -->
                        <br>
                        <br>
                           
<%@include file="/includes/footer.jsp" %>
        