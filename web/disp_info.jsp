<%-- 
    Document   : disp_info
    Created on : Jul 18, 2012, 6:49:42 PM
    Author     : Rob_Weaver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/includes/header.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
        
         <!-- CSS page style customization -->
        <style type="text/css">
           
            body{background-color:lightgrey; }
            table{background-color: white;}
            #coup{border-color:none; background-color: white; width: 220px;
                height: 100px; padding: 5px;}
            
            
        </style>
        
    </head>
    <body>
        
        
        <%!
            // variables for page display
            int pageCount =0; 
            int coupNum = 1000;
            
        %>
        
        <!-- Displays the date the information was added -->
        <p>This information was added on <%= new Date()%></p>
        
        <!-- Table displaying the info back to the user-->
        
        <table border="1" cellpadding="5">
                <tr>
                    <td align="right">First name:</td>
                    <td>${user.firstName}</td>
                </tr>
                <tr>
                    <td align="right">Last name:</td>
                    <td>${user.lastName}</td>
                </tr>
                <tr>
                    <td align="right">Email address:</td>
                    <td>${user.emailAddress}</td>
                </tr>
                <tr>
                    <td align="right">Address:</td>
                    <td>${user.address}</td>
                </tr>
                <tr>
                    <td align="right">City:</td>
                    <td>${user.city}</td>
                </tr>
                <tr>
                    <td align="right">State:</td>
                    <td>${user.state}</td>
                </tr>
                <tr>
                    <td align="right">Zip Code:</td>
                    <td>${user.zipCode}</td>
                </tr>
                <tr>
                    <td align="right">Country:</td>
                    <td>${user.country}</td>
                </tr>
        </table>
                
                <br>

                <p>Congratulations! You are now receiving mail for all
                    our products!</p>
        
        <br>
        <br>
        <p>If you would like to add another email address you can add another by<br>
            hitting the Back button on your browser or the Return button below.</p>
        <br>
        
        <!-- Return Button puts you back at the home "index.jsp" page-->
        <form action="join_email.jsp" method="post">
            <input type="submit" value="Return">
        </form>
        
        
        
        <%
        if (pageCount > 6){pageCount=0;}    
        pageCount++;
        %>
        
        <p>This page has been accessed <%= pageCount %> times</p>
        
        <!-- Shows coupons to the user, changes based on number of times the 
            page has been accessed from 1-6 times. Also displays a different 
            coupon number until the server has been reset
          -->
        <%  for (int i = 0; i < pageCount;i++)
            { 
        %>
        <div id="coup">
        <p>========================<br>
           Coupon for your next purchase!<br>
           Coupon # <%=coupNum %><br>
           ========================</p>
        </div>
        <%  
            coupNum++;
            }
        %>
        <%@include file="/includes/footer.jsp" %>            
    </body>
</html>
