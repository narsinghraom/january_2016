<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="bean.*" %>
     <%@ page import="dao.*" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var xmlHttp;  
var xmlHttp;
function showState(str){
if (typeof XMLHttpRequest != "undefined"){
xmlHttp= new XMLHttpRequest();


}
  else if (window.ActiveXObject){
  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
  }
  if (xmlHttp==null){
  alert("Browser does not support XMLHTTP Request")
  return;
  } 
  var url="Search_Ajax.jsp";
  url +="?count=" +str;
  xmlHttp.onreadystatechange = stateChange;
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
  }

  function stateChange(){   
  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
   document.getElementById("state").innerHTML=xmlHttp.responseText; 
     }
  }


</script>

</head>
<body>

<input type="text" name="country" id="country" onkeyup="showState(this.value)">
<%
String country_Name=request.getParameter("count");
if(country_Name!=null)
{
DBConnection connect=new DBConnection();
ArrayList<StateBean> state_array=connect.getState(country_Name);
Iterator<StateBean> iterator=state_array.iterator();
StateBean statebean=null;
while(iterator.hasNext())
{
	statebean=(StateBean)iterator.next();
}

if(statebean!=null)
{
	%>
	<input type="text" disabled="disabled" value=<%=statebean.getStateName() %>>
	<%
}
}

%>
<div id="state"></div>
</body>
</html>