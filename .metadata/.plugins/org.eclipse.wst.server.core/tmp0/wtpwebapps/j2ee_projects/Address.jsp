<%@page import="java.util.Iterator"%>
<%@page import="bean.CountryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address</title>
</head>
<body>
<center>
    <h1> Select country</h1>
        <select>
        <%  DBConnection connect=new DBConnection();
        ArrayList<CountryBean> country_array=connect.getCountry();
        Iterator iterator=country_array.iterator();
        while(iterator.hasNext())
        {
        	CountryBean country_bean=(CountryBean)iterator.next();
        %>
            <option><%= country_bean.getCountryName()%></option>
        <% } %>
        </select>
</center>
</body>
</html>