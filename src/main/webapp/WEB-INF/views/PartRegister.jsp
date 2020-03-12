<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
<%@include file="UserMenu.jsp" %>
	<div class="container">
<div class="card">

			<div class="card-header bg-primary text-center text-white text-uppercase">
				<H3>WELCOME PART PAGE</H3>
			</div>

			<div class="card-body">

				<form:form action="save" method="POST" modelAttribute="part">


					<div class="row">
						<div class="col-4">
							<label for="partCode">CODE</label>
						</div>
						<div class="col-4">
							<form:input path="partCode" class="form-control" />
						</div>
						<div class="col-4"><!-- Error Message --></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="partLine">PARTLINE</label>
						</div>
						<div class="col-4">
							<form:input path="partLine" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="partWid">PART-WIDTH</label>
						</div>
						<div class="col-4">
							<form:input path="partWid" class="form-control" />
						</div>
						<div class="col-4"><!-- Exception --></div>
					</div>



					<div class="row">
						<div class="col-4">
							<label for="partHgt">PART-HEIGHT</label>
						</div>
						<div class="col-4">
							<form:input path="partHgt" class="form-control" />
						</div>
						<div class="col-4"><!-- Exception msge --></div>
					</div>




					<div class="row">
						<div class="col-4">
							<label for="baseCost">BASE-COST</label>
						</div>
						<div class="col-4">
							<form:input path="baseCost" class="form-control" />

						</div>
						<div class="col-4"><!-- exception --></div>
					</div>
					
				 <!-- Drop Down for uom model -->  
					<div class="row">
						  <div class="col-4">
							<label for="uomdb.uomId">UOM</label>
						  </div>
						<div class="col-4">
							<form:select path="uomdb.uomId" class="form-control">
								<form:option value="" >--select--</form:option>
								  <form:options items="${uomMap}"/>
																
							</form:select>									
						</div>
						<div class="col-4"><!-- exception --></div>
					</div>
						
			<%-- 	 <!-- Drop Down for OrderMethod model -->  
						<div class="row">
						  <div class="col-4">
							<label for="ordsale.orderId">OrderMethodCode</label>
						  </div>
						<div class="col-4">
							<form:select path="ordsale.orderId" class="form-control">
								<form:option value="" >--select--</form:option>
								  <form:options items="${omSaleMap}"/>
																
							</form:select>									
						</div>
						<div class="col-4"><!-- exception --></div>
						
						
				</div> --%>
					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">BASE-CURRENCY</label>
						</div>
						<div class="col-4">
							<form:input path="baseCurrency" class="form-control" />
						</div>
						<div class="col-4"><!-- exception --></div>
					</div>
					
					
					<div class="row">
						<div class="col-4">
							<label for="desc">DECSRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="desc" class="form-control" />
						</div>
						<div class="col-4"><!-- exception --></div>
					</div>
					
					
					

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />

						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${!empty msg }">
				<div class="card-footer bg-info text-white text-center">
					<b>${msg}</b>
				</div>
			</c:if>
		</div><!-- card end -->
	</div><!-- container end -->
</body>
</html>







