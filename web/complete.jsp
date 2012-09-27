<%-- 
    Document   : complete
    Created on : Aug 27, 2012, 12:18:44 PM
    Author     : Rob_Weaver
--%>

<!--<jsp:include page="/includes/header.html" /> -->




<td valign="top">

<h1>Thank you, ${user.firstName}</h1>

<!-- store email address as a global variable and use EL to display it -->

<p>Your order has been submitted. We'll begin processing your 
order right away. If you have any questions about your order, 
please feel free to contact us at: BDcustomer.service@BestDeals.com
<a href="mailto:${custServEmail}">${custServEmail}</a></p>

</td>


<jsp:include page="/includes/footer.jsp" />
