<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="saveuom" method="post">
<pre>
Uom Type:
	<select name="uomtype">
		<option>--select--</option>
		<option>Packing</option>
		<option>No Packing</option>
		<option>--NA--</option>
	</select>
Uom Model:
		<input type="text" name="uomMod"/>
Description:
		<textarea name="uomDesc"></textarea>
	<input type="submit" value="CREATE UOM"/>
	</pre>
	</form>
	${uom}

</body>
</html>