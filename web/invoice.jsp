<%-- 
    Document   : invoice
    Created on : Aug 23, 2012, 3:01:45 PM
    Author     : Rob_Weaver
--%>

<!--<jsp:include page="/includes/header.html" />-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Your invoice</h1>

<table border="0" cellspacing="5">
  <tr><td><b>Date:</b></td>
      <td width="400">${invoice.invoiceDateDefaultFormat}</td>
      <td></td>
  </tr>
  <tr valign="top">
    <td><b>Ship To:</b></td>
    <td>${user.address}, ${user.city}, ${user.state},${user.zipCode}</td>
    <td></td>
  </tr>
  <tr><td colspan="3"><hr></td></tr>
  <tr><td><b>Qty</b></td>
      <td><b>Description</b></td>
      <td><b>Price</b></td>
  </tr>

  <c:forEach var="item" items="${invoice.lineItems}">
  <tr>
    <td><p>${item.quantity}</td>
    <td><p>${item.product.description}</td>
    <td><p>${item.totalCurrencyFormat}</td>
  </tr>
  </c:forEach>

  <tr>
    <td><b>Total:</b></td>
    <td></td>
    <td>${invoice.invoiceTotalCurrencyFormat}</td>
  </tr>
</table>

<form action="<c:url value='/user.jsp' />" method="post">
     <input type="submit" value="Edit Address">
</form>
     <br>

<form action="<c:url value='/credit_card.jsp' />" method="post">
     <input type="submit" value="Continue">
</form>
     <br>

<jsp:include page="/includes/footer.jsp" />