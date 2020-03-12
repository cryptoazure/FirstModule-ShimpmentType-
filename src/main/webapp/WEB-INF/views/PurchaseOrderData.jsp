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
	<h3>WELCOME TO PURCHASE ORDER PAGE</h3>
	
	<c:choose>
		<c:when test="${!empty list}">
			<table border="1">
				<tr><th>Order ID</th>
					<th>ORDER CODE</th>
					<th>REFERENCE NUMBER</th>
					<th>QUALITY CHECK</th>
					<th>DEFAUIL STATUS</th>
					<th>DESCRIPTION</th>
					<th colspan="3">Operation</th>

				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.ship.shipId}
						<td>${ob.orderCode}</td>
						<td>${ob.refNum}</td>
						<td>${ob.qtyCheck}</td>
						<td>${ob.status}</td>
						<td>${ob.note}</td>
						
						<td><a href="delete?pid=${ob.poId}"> <img
								src="../resources/images/delete.jfif" width="30" height="30" />
								</a>
						<%-- </a></td>
						<td><a href="edit?pid=${ob.poId}"> <img
								src="../resources/images/edit.jfif" width="30" height="30" />
						</a></td>
						<td><a href="view?pid=${ob.poId}"> <img
								src="../resources/images/view.jfif" width="30" height="30" />
						</a></td> --%>
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