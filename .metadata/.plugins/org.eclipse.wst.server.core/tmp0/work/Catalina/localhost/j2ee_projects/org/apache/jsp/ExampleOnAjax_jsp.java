/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.64
 * Generated at: 2016-01-04 05:46:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import bean.*;
import dao.*;

public final class ExampleOnAjax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>  \r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">  \r\n");
      out.write("var xmlHttp;  \r\n");
      out.write("var xmlHttp;\r\n");
      out.write("function showState(str){\r\n");
      out.write("if (typeof XMLHttpRequest != \"undefined\"){\r\n");
      out.write("xmlHttp= new XMLHttpRequest();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("  else if (window.ActiveXObject){\r\n");
      out.write("  xmlHttp= new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("  }\r\n");
      out.write("  if (xmlHttp==null){\r\n");
      out.write("  alert(\"Browser does not support XMLHTTP Request\")\r\n");
      out.write("  return;\r\n");
      out.write("  } \r\n");
      out.write("  var url=\"state.jsp\";\r\n");
      out.write("  url +=\"?count=\" +str;\r\n");
      out.write("  xmlHttp.onreadystatechange = stateChange;\r\n");
      out.write("  xmlHttp.open(\"GET\", url, true);\r\n");
      out.write("  xmlHttp.send(null);\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  function stateChange(){   \r\n");
      out.write("  if (xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\"){   \r\n");
      out.write("   document.getElementById(\"state\").innerHTML=xmlHttp.responseText; \r\n");
      out.write("    /* var jsonArray=xmlHttp.responseText;\r\n");
      out.write("   var select = document.getElementById('state');\r\n");
      out.write("  var option;\r\n");
      out.write("  for (var i = 0; i < jsonArray.length; i++) {\r\n");
      out.write("    option = document.createElement('option');\r\n");
      out.write("    option.text = jsonArray[i];\r\n");
      out.write("    select.add(option);\r\n");
      out.write("  }     */\r\n");
      out.write("  }\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  function showCity(str){\r\n");
      out.write("  if (typeof XMLHttpRequest != \"undefined\"){\r\n");
      out.write("    xmlHttp= new XMLHttpRequest();\r\n");
      out.write("    }\r\n");
      out.write("  else if (window.ActiveXObject){\r\n");
      out.write("    xmlHttp= new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("    }\r\n");
      out.write("  if (xmlHttp==null){\r\n");
      out.write("  alert(\"Browser does not support XMLHTTP Request\")\r\n");
      out.write("  return;\r\n");
      out.write("  } \r\n");
      out.write("  var url=\"city.jsp\";\r\n");
      out.write("  url +=\"?count=\" +str;\r\n");
      out.write("  xmlHttp.onreadystatechange = stateChange1;\r\n");
      out.write("  xmlHttp.open(\"GET\", url, true);\r\n");
      out.write("  xmlHttp.send(null);\r\n");
      out.write("  }\r\n");
      out.write("  function stateChange1(){   \r\n");
      out.write("  if (xmlHttp.readyState==4 || xmlHttp.readyState==\"complete\"){   \r\n");
      out.write("  document.getElementById(\"city\").innerHTML=xmlHttp.responseText;   \r\n");
      out.write("  }   \r\n");
      out.write("  }\r\n");
      out.write("  </script>  \r\n");
      out.write("  </head>  \r\n");
      out.write("  <body>  \r\n");
      out.write("  <select name='country' onchange=\"showState(this.value)\">   \r\n");
      out.write("        ");
  DBConnection connect=new DBConnection();
        ArrayList<CountryBean> country_array=connect.getCountry();
        Iterator iterator=country_array.iterator();
        while(iterator.hasNext())
        {
        	CountryBean country_bean=(CountryBean)iterator.next();
        
      out.write("\r\n");
      out.write("            <option>");
      out.print( country_bean.getCountryName());
      out.write("</option>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("      </select>  \r\n");
      out.write("      <br>  \r\n");
      out.write("      <div >  \r\n");
      out.write("      <select name='state' id='state' onchange=\"showCity(this.value)\">  \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      </select>  \r\n");
      out.write("      </div>  \r\n");
      out.write("\r\n");
      out.write("      <div >  \r\n");
      out.write("      <select name='city' id='city' >  \r\n");
      out.write("       \r\n");
      out.write("      </select>  \r\n");
      out.write("      </div>\r\n");
      out.write("      </body> \r\n");
      out.write("      </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}