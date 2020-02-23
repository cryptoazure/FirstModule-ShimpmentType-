<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO SHIPMENT TYPE DATA PAGE</h3>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>MODE</th>
					<th>CODE</th>
					<th>ENABLE</th>
					<th>GRADE</th>
					<th>NOTE</th>
					<th colspan="3">Operations</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.shipId}</td>
						<td>${ob.shipMode}</td>
						<td>${ob.shipCode}</td>
						<td>${ob.enbShip}</td>
						<td>${ob.shipGrad}</td>
						<td>${ob.shipDesc}</td>
						
						<td>
						<a href="delete?sid=${ob.shipId}">DELETE</a>
						</td>
						<td>
						<a href="edit?sid=${ob.shipId}">EDIT</a>
						</td>
						<td>
						<a href="excel">Excel Export</a>
						</td>

					</tr>
				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
			<H4>NO DATA FOUND!!!</H4>
		</c:otherwise>
	</c:choose>
</body>
</html>