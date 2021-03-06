
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>WELCOME TO PART DATA PAGE</H3>

			</div>
			<div class="card-body">
				<a href="excel"><img src="../resources/images/BulkExcel.png"
					width="100" height="40" /></a> <a href="pdf"><img
					src="../resources/images/BulkPdf.png" width="100" height="40" /></a>
				<c:choose>
					<c:when test="${!empty list }">
						<table class="table table-hover">
							<tr class="bg-success text-white">
								<th>PART-CODE</th>
								<th>PART-LINE</th>
								<th>PART-WIDTH</th>
								<th>PART-HEIGHT</th>
								<th>BASE-COST</th>
								<th>UOM</th>
								<th>BASE-CURRENCY</th>
								<th>DESCRIPTION</th>
								<th colspan="3">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="ob">
								<tr>

									<td>${ob.partCode}</td>
									<td>${ob.partLine}</td>
									<td>${ob.partWid}</td>
									<td>${ob.partHgt}</td>
									<td>${ob.baseCost}</td>
									<td>${ob.uomdb.uomId.uomMod}</td>
									<td>${ob.baseCurrency}</td>
									<td>${ob.desc}</td>
									<td><a href="delete?sid=${ob.id}" class="btn btn-danger">
											<!-- <img src="../resources/images/delete.png" width="20" height="20" /> -->
											DELETE
									</a></td>
									<td><a href="edit?sid=${ob.id}" class="btn btn-info">
											<!-- <img	src="../resources/images/edit.png" width="20" height="20" /> -->
											EDIT
									</a></td>
									<td><a href="view?sid=${ob.id}" class="btn btn-warning">
											<!-- <img src="../resources/images/view.png" width="20" height="20" /> -->
											VIEW
									</a></td>
								</tr>
								<%-- <td>${ob.uomdb.uomMod}</td> --%>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<H4>NO DATA FOUND!!</H4>
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test="${!empty message}">
				<c:choose>
					<c:when test="${opr eq 'DEL'}">
						<div class="card-footer bg-danger text-white text-center">
							<b>${message}</b>
						</div>
					</c:when>
					<c:otherwise>
						<div class="card-footer bg-info text-white text-center">
							<b>${message}</b>
						</div>

					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
		<!-- card end -->


	</div>
	<!-- container end -->
 </body>
</html>
