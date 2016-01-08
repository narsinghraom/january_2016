<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp</title>
<script type="text/javascript">
var txtval;
function load()
{
	txtval=document.getElementById("val").value;
	}
</script>
</head>
<body>
<input type="text" id="val" value="1254" onkeypress="load()">
<%
String str = "<script>document.writeln(txtval)</script>";
out.println(str);
%>
</body>
</html>