<!--<jsp:include page="/includes/header.html" />-->



<script language="JavaScript">
function validate(form) 
{
    console.log(form.toString());

    var _firstName  = document.getElementById('firstName');
    var _firstNameValue = _firstName.value;
    
    var _lastName  = document.getElementById('lastName');
    var _lastNameValue = _lastName.value;
    
    var _emailAddress  = document.getElementById('emailAddress');
    var _emailAddressValue = _emailAddress.value;
    
    var _address  = document.getElementById('address');
    var _addressValue = _address.value;
    
    var _city  = document.getElementById('city');
    var _cityValue = _city.value;
    
    var _state  = document.getElementById('state');
    var _stateValue = _state.value;
    
    var _zipCode  = document.getElementById('zipCode');
    var _zipCodeValue = _zipCode.value;
    
    var _country  = document.getElementById('country');
    var _countryValue = _country.value;
    

    
    if (_firstNameValue=="") 
    {
            alert("Please fill in your first name");
            form.firstName.focus();
    }
    else if (_lastNameValue.value=="") 
    {
            alert("Please fill in your last name");
            form.lastName.focus();
    }
    else if (_emailAddressValue.value=="") 
    {
            alert("Please fill in your email address");
            form.emailAddress.focus();
    }
    else if (_addressValue.value=="") 
    {
            alert("Please fill in your street address");
            form.address.focus();
    }
    else if (_cityValue.value=="") 
    {
            alert("Please fill in your city name");
            form.city.focus();
    }
    else if (_stateValue.value=="") 
    {
            alert("Please fill in your state");
            form.state.focus();
    }
    else if (_zipCodeValue.value=="") 
    {
            alert("Please fill in your zip/postal code");
            form.zipCode.focus();
    }
    else if (_countryValue.value=="") 
    {
            alert("Please fill in your country");
            form.country.focus();
    }
    else 
    {
            form.submit();
    }
}
</script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Enter your name and contact information</h1>

<form action="<c:url value='/processUser' />" method=post>
<table border="0" cellpadding="5">
  <tr>
    <td></td>
    <td align=left>Required <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>First Name</td>
    <td><input type="text" name="firstName"  size="20" maxlength=20 id ="firstName"
               value="${user.firstName}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Last Name</td>
    <td><input type=text name="lastName" size=20 id ="lastName"
               value="${user.lastName}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Email Address</td>
    <td><input type=text name="emailAddress" size=20 id ="emailAddress"
               value="${user.emailAddress}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Address</td>
    <td><input type=text name="address" size=20 id ="address"
               value="${user.address}"> 
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>City</td>
    <td><input type=text name="city" size=20 id ="city"
               value="${user.city}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>State</td>
    <td><input type=text name="state" size=20 id ="state"
               value="${user.state}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Zip Code</td>
    <td><input type=text name="zipCode" size=20 id ="zipCode"
               value="${user.zipCode}">
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>Country</td>
    <td><input type=text name="country" size=20 id ="country"
               value="${user.country}"> 
               <font color=red>*</font></td>
  </tr>
  <tr>
    <td align=right>&nbsp;</td>
    <td><!--<input type="button" value="Continue" onClick="validate(this.form)">--></td>
  </tr>
</table>

               
<input type="button" value="Continue" onClick="validate(this.form)">               
</form>


<jsp:include page="/includes/footer.jsp" />