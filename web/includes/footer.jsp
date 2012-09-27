<%-- 
    Document   : footer
    Created on : Aug 1, 2012, 3:32:19 PM
    Author     : Rob_Weaver
--%>

<!--
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         -->
         <br>
         <br>
         <br>
         <br>
         <br></br>
<div id="footer">
    
<%@page import="java.util.*" %>   

<% 
    //gets the current date 
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>

<p style="color:white;"><small>&copy; Copyright <%= currentYear %> Robert Weaver All rights reserved</small></p>
    

</div>
 <!--   </body>
</html> -->
