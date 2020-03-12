<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO VIEW TYPE PAGE</h3>
	<table border="1">
		<tr>
			<th>ID</th><td>${ob.uomId}</td>
		</tr>
		<tr>
			<th>TYPE</th><td>${ob.uomType}</td>
		</tr>
		<tr>
			<th>MODEL</th><td>${ob.uomMod}</td>
		</tr>
		<tr>
			<th>DESC</th><td>${ob.uomDesc}</td>
		</tr>

	</table>
</body>
</html>