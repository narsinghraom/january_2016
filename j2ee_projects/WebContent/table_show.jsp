<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var request;
function sendInfo()
{
	var valued=document.myform.table.value;
	//var url="indext1.jsp?val="+valued;
	var  url="indexdatabase.jsp?val="+valued;
	if(window.XMLHttpRequest)
		{
		request =new XMLHttpRequest();
		}
	else if(window.ActiveXObject)
		{
		request=new ActiveXObject("Microsoft.XMLHTTP");
		}

try
{
	request.onreadystatechange=getinfo;
	request.open("GET",url,true);
	request.send(); 

} catch(e)
	{
		alter("unable to connect to server");
	}
}
	function getinfo()
	{
		if(request.readyState==4)
			{
			var val=request.responseText;
			
			document.getElementById('vanaja').innerHTML=val;
		
			}
	}
	
</script>
</head>
<body>
<marquee><h1>This is a examle of the AJaX</h1></marquee>
<form name="myform">
<input type="text" name="table">
<input type="button" value="Show Table" onclick="sendInfo()" >
</form>

<span id="vanaja"></span>
</body>
</html>