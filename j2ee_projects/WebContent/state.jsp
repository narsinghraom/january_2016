<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<%@ page import="bean.*" %>
<%@ page import="dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String country_name=request.getParameter("count");
DBConnection connect=new DBConnection();
ArrayList<StateBean> state_array=connect.getState(country_name);
Iterator iterator=state_array.iterator();
while(iterator.hasNext())
{
	StateBean state_bean=(StateBean)iterator.next();
%>
<select>
<option>
    <%= state_bean.getStateName()%>
    </option>
    </select>
<% } %>

</body>
</html>