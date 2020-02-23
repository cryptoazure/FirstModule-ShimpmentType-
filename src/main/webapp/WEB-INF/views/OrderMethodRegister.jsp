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
<form:form action="save" method="POST" modelAttribute="orderMethod">

Order Mode:
	<form:radiobutton path="orderMode" value="sale" />Sale
	<form:radiobutton path="orderMode" value="Purchase" />Purchase
Order Code:
		<form:input path="orderCode" />
Order Type:
		<form:select path="orderType">
			<form:option value="">--select</form:option>
			<form:option value="FIFO">FIFO</form:option>
			<form:option value="LIFO">LIFO</form:option>
			<form:option value="FCFO">FCFO</form:option>
			<form:option value="FEFO">FEFO</form:option>	
		</form:select>
Order Accept:
		<form:checkbox path="orderAccept" value="Multi-Model" />Multi-Model
		<form:checkbox path="orderAccept" value="Accept-Return" />Accept-Return
		
Description:
	<form:textarea path="description" />
	<input type="submit" value="CREATE" />
	</form:form>
	</pre>
	${message}
</body>
</html>