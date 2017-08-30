<%-- 
    Document   : erroraddnews1
    Created on : 04-May-2017, 23:07:33
    Author     : amdb2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="springnews.model.LoginBean"%>
<%@page import="springnews.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="springnews.model.News"%>
<%@page import="springnews.model.Employee"%>
<% LoginBean login = (LoginBean)session.getAttribute("login");
   if(login == null){response.sendRedirect("index.jsp");} 
   if(login.getLv() != 2){response.sendRedirect("RemoveServlet2");} %> 
<% String username = (String)session.getAttribute("username");%>
<% ArrayList<News> mainnews = (ArrayList)request.getAttribute("mainnews"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
    body {
	background-color: #999;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
    </style>
    </head>
    <body>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" width="1000" height="131"></td>
          </tr>
          <tr>
            <td bgcolor="#FFCC00">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FF3300"><table width="1000" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="209">&nbsp;</td>
                <td width="504"><strong>ERROR</strong></td>
                <td width="267">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>เกิดข้อผิดพลาด กรุณา ลองใหม่อีกครั้ง</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF"><a href="listnews">BACKTO_NEWSList</a></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
    </body>
</html>
