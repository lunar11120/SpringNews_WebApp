<%-- 
    Document   : deletesuccess
    Created on : 28-Apr-2017, 16:18:29
    Author     : amdb2
--%>
<%@page import="springnews.model.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% LoginBean login = (LoginBean)session.getAttribute("login");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
    body {
	background-color: #999;
}
    </style>
    </head>
    <body>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" alt="" width="1000" height="131"></td>
          </tr>
          <tr>
            <td bgcolor="#FFCC00">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFCC00"><img src="imagespring/delete_employee_success.jpg" width="456" height="145"></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFCC00">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF"><table width="1002" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="928" bgcolor="#FFFFFF">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><a href="ListEmployeeServlet"><img src="imagespring/adminb05.jpg" width="256" height="80"></a></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
        </table>
        <h1>&nbsp;</h1>
        <h1><br>
    </h1>
</body>
</html>
