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
	<h3>WELCOME TO UOM TYPE DATA PAGE</h3>
	<a href="excel"> <img src="../resources/images/excel.jfif"
		width="70" height="50" />
	</a>
	<a href="pdf"> <img src="../resources/images/pdf.jfif" width="70"
		height="50" />
	</a>
	<c:choose>
		<c:when test="${!empty list}">
			<table border="1">
				<tr>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>DESC</th>
					<th colspan="3">Operation</th>

				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.uomType}</td>
						<td>${ob.uomMod}</td>
						<td>${ob.uomDesc}</td>
						<td><a href="delete?uid=${ob.uomId}"> <img
								src="../resources/images/delete.jfif" width="30" height="30" />
						</a></td>
						<td><a href="edit?uid=${ob.uomId}"> <img
								src="../resources/images/edit.jfif" width="30" height="30" />
						</a></td>
						<td><a href="view?uid=${ob.uomId}"> <img
								src="../resources/images/view.jfif" width="30" height="30" />
						</a></td>
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