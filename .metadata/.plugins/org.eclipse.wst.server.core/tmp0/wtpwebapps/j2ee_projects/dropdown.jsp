<%@page import="java .util.Iterator"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="example_Ajax.*" %>

<%ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
</HEAD>
<script type="text/javascript">
	function fn()
	{
		var coutry=document.getElementById("country");
		var states=documment.getElementById("states")
		var stateList = states[coutry.value];
		changeSelect('state', stateList, stateList);
			
	}
	function changeSelect(fieldID, newOptions, newValues) {
		  selectField = document.getElementById(fieldID);
		  selectField.options.length = 0;
		  for (i=0; i<newOptions.length; i++) {
		    selectField.options[selectField.length] = new Option(newOptions[i], newValues[i]);
		  }
		}
</script>
<form name="myform" ACTION="" METHOD="POST">
<BODY BGCOLOR=##f89ggh>
<table border=1>
<tr>
<td>
Country:</td>
<td>
<select type="dropdown" name="country" id="country" onchannge="fn()">
<%

DBCountry dbc=new DBCountry();
Citybean bean=null;
ArrayList<Citybean> array=new ArrayList<Citybean>(); 
array=dbc.getDetails();
 Iterator itr=array.iterator();
while(itr.hasNext())
{
	bean=(Citybean)itr.next();
 %>
 <option value=><%=bean.getCountry()%>
	<%} %>

</option>
	</select>
   </td></tr></table>
   <table border=1>
<tr>
<td>
States:</td>
<td>
<select type="dropdown" name="states" id="states" >

<%
String country=request.getParameter("country");

DBCountry dbs=new DBCountry();
Citybean bean1=null;
ArrayList<Citybean> array1=new ArrayList<Citybean>(); 
array1=dbs.getDetails1(country);
 Iterator itr1=array1.iterator();
while(itr1.hasNext())
{
	bean1=(Citybean)itr1.next();
 %>
 <option value=><%=bean1.getStates()%>
	<%} %>

</option>

	</select>
   </td></tr></table>
  
  
</form>
</BODY>
</HTML>