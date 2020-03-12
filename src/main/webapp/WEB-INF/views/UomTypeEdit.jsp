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


	<form:form action="update" method="POST" modelAttribute="uom">
		<pre>
				Uom Id:
				<form:input path="uomId" readonly="true" />
				Uom Type:
					<form:select path="uomType">
						<form:option value="">--select--</form:option>
						<form:option value="Packing">Packing</form:option>
						<form:option value="No Packing">No Packing</form:option>
						
					</form:select>
				Uom Model:
						<form:input path="uomMod"/>	
					   
				Description:
				<form:textarea path="uomDesc" />
							<input type="submit" value="UPDATE" />
					
</pre>
	</form:form>
	${list}
</body>
</html>