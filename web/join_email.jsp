<%-- 
    Document   : index
    Created on : Jul 9, 2012, 6:52:09 PM
    Author     : Rob_Weaver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/includes/header.html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
      
        
        <!-- CSS page style customization -->
        <style type="text/css">
            h1{font-size:28px; }
            h2{font-size:24px; }
            h3{font-size:16px; color:red;}
            body{background-color:cornflowerblue; }
            
        </style>
        
        <!-- javaScript for page validation NOT NEEDED AFTER CH 7 -->
        <script language="JavaScript">
            
            function validate(form)
            {
                if (form.firstname.value=="")
                {
                    alert("Please fill in your first name.");
                    form.firstname.focus();
                }
                else if (form.lastname.value=="")
                {
                    alert("Please fill in your last name.");
                    form.lastname.focus();
                }
                else if (form.emailaddress.value=="")
                {
                    alert("Please fill in your email address.");
                    form.emailaddress.focus();
                }
                else if (form.address.value=="")
                {
                    alert("Please fill in your address.");
                    form.address.focus();
                }
                else if (form.city.value=="")
                {
                    alert("Please fill in your city.");
                    form.city.focus();
                }
                else if (form.state.value=="")
                {
                    alert("Please fill in your state.");
                    form.state.focus();
                }
                else if (form.zipCode.value=="")
                {
                    alert("Please fill in your zipCode.");
                    form.zipCode.focus();
                }
                else if (form.country.value=="")
                {
                    alert("Please fill in your country.");
                    form.country.focus();
                }
                else
                {
                    form.submit();
                }
                
            }
            
        </script>
       
       
       
        
    </head>
    <body>
        
  
       
        <h1>Hello Customer!</h1>
        <h2>Welcome to our Sign-Up center</h2>
        
        <!-- action change to page to display-->
        
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <p><b><i>${message}</i></b></p>

        
        <form name="info" action="AddToEmailServlet" method="post">
            <table border="0" cellspacing="5">
                
                <tbody>
                    <tr>
                        <td align="right">First Name</td>
                        <td><input type="text" name="firstName" 
                                   value="${user.firstName}"</td>
                    </tr>
                    <tr>
                        <td align="right">Last Name</td>
                        <td><input type="text" name="lastName"
                                   value="${user.lastName}"></td>
                    </tr>
                    <tr>
                        <td align="right">Email Address</td>
                        <td><input type="text" name="emailAddress" 
                                   value="${user.emailAddress}"</td>
                    </tr>
                    <tr>
                        <td align="right">Address</td>
                        <td><input type="text" name="address" 
                                   value="${user.address}"</td>
                    </tr>
                    <tr>
                        <td align="right">City</td>
                        <td><input type="text" name="city" 
                                   value="${user.city}"</td>
                    </tr>
                    <tr>
                        <td align="right">State</td>
                        <td><input type="text" name="state" 
                                   value="${user.state}"</td>
                    </tr>
                    <tr>
                        <td align="right">Zip Code</td>
                        <td><input type="text" name="zipCode" 
                                   value="${user.zipCode}"</td>
                    </tr>
                    <tr>
                        <td align="right">Country</td>
                        <td><input type="text" name="country" 
                                   value="${user.country}"</td>
                    </tr>
                </tbody>
            </table>
            
            
            <h2>Select one</h2>
            <input type="checkbox" name="mF" value="male" >Male<br>
            <input type="checkbox" name="mF" value="female">Female<br>
            <br>
          
            
            <p>Hit the Submit button after all the required fields are filled out.<br>
                You will then be sent to a confirmation page to ensure everything has<br>
                been entered correctly.</p>
            
            <br> 
           <input type="submit" value="Submit">
           <!--<input type="button" value="Submit" onClick="validate(this.form)"> --> 
            
        </form>
        
        
        
      
        
       <br>  
        
    <%@include file="/includes/footer.jsp" %>    
    </body>
</html>
