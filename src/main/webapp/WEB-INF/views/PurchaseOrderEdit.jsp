<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h3>
		<br>PURCHASE ORDER EDIT PAGE<br>
	</h3>
	<form:form action="edit" method="POST" modelAttribute="purchaseOrder">
		<pre>
		PURCHASE ID:
		<form:input path="poId" readonly="true" />
		ORDER CODE:
		<form:input path="orderCode"/>
		REFERENCE NUMBER:
		    	<form:input path="refNum" />
		QUALITY CHECK:
		       <form:radiobutton path="qtyCheck" value="Required" />Required
	           <form:radiobutton path="qtyCheck" value="Not Required" />Not Required
	     DEFAUIL STATUS:
		   <form:input path="status" />
		
		NOTE:
		<form:textarea path="note" />
			<input type="submit" value="UPDATE" />
	
	</pre>
	</form:form>
	${list}
</body>
</html>