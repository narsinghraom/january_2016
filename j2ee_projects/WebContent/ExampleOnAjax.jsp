<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="bean.*" %>
<%@ page import="dao.*" %>
<html>
<head>  
<script language="javascript" type="text/javascript">  
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
  var url="state.jsp";
  url +="?count=" +str;
  xmlHttp.onreadystatechange = stateChange;
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
  }

  function stateChange(){   
  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
   document.getElementById("state").innerHTML=xmlHttp.responseText; 
    /* var jsonArray=xmlHttp.responseText;
   var select = document.getElementById('state');
  var option;
  for (var i = 0; i < jsonArray.length; i++) {
    option = document.createElement('option');
    option.text = jsonArray[i];
    select.add(option);
  }     */
  }
  }

  function showCity(str){
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
  var url="city.jsp";
  url +="?count=" +str;
  xmlHttp.onreadystatechange = stateChange1;
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
  }
  function stateChange1(){   
  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
  document.getElementById("city").innerHTML=xmlHttp.responseText;   
  }   
  }
  </script>  
  </head>  
  <body>  
  <select name='country' onchange="showState(this.value)">   
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
      <br>  
      <div >  
      <select name='state' id='state' onchange="showCity(this.value)">  
      
      
      </select>  
      </div>  

      <div >  
      <select name='city' id='city' >  
       
      </select>  
      </div>
      </body> 
      </html>