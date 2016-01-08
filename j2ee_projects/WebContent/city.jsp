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
String state_name=request.getParameter("count");
DBConnection connect=new DBConnection();
ArrayList<CityBean> city_array=connect.getCity(state_name);
Iterator iterator=city_array.iterator();
while(iterator.hasNext())
{
	CityBean city_bean=(CityBean)iterator.next();
%>
<select>
<option>
    <%= city_bean.getCityName()%>
    </option>
    </select>
<% } %>

</body>
</html>