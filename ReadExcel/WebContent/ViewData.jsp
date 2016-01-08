<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<%@page import="bean.*" %>
<%@page import="example.readexcel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>US Info</title>
<style>
table,th,td{
border: 1px solid black;
border-collapse: collapse;
}
th.td,h1{
padding:15px;
font-family: Footlight MT Light;
}

</style>
</head>
<body>
<%
String designation=request.getParameter("List");
%>

<%
	ArrayList<ZipBean> arraybean=new ArrayList<ZipBean>();
   
ReadExcel1 xl=new ReadExcel1();
 arraybean=xl.getDetails();
  Iterator<ZipBean> iterator=arraybean.iterator();
%>
<table>


<%
	while(iterator.hasNext())
{
		int sno=1;
		ZipBean zipbean=(ZipBean)iterator.next();
%>
<tr>

<td><%=sno %></td>
<td><%= zipbean.getZip() %></td>
<td><%=zipbean.getState() %></td>
<td><%=zipbean.getCountry() %></td>
<td><%=zipbean.getCity() %></td>
<td><%=zipbean.getLatitude() %></td>
<td><%=zipbean.getLongitude() %></td>


</tr>
<%
sno++;
} %>
</table>
</body>
</html>