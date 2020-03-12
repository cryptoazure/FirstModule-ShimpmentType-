<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H3>WELCOME TO ORDER METHOD REGISTER PAGE</H3>
	<pre>
<form:form action="save" method="POST" modelAttribute="purchaseOrder">

	Order Code:
			<form:input path="orderCode" />
    Shipment Code:
    	   <form:select path="ship.shipId" class="form-control">
    	   	<form:option value="">--select--</form:option>
    	    <form:options items="${shipMap}"/>
    	   
    	   </form:select>
	Reference Number:
			<form:input path="refNum" />
	Quality Check:
	       <form:radiobutton path="qtyCheck" value="Required" />Required
	       <form:radiobutton path="qtyCheck" value="Not Required" />Not Required
	Default Status:
		   <form:input path="status" />
	Note:
		   <form:textarea path="note" />
       <input type="submit" name="Placed Order" />
</form:form>
	</pre>
	${message}
</body>
</html>