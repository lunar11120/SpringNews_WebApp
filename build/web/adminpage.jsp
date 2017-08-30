<%-- 
    Document   : adminpage
    Created on : 27-Apr-2017, 02:13:12
    Author     : amdb2
--%>
<%@page import="springnews.model.News"%>
<%@page import="springnews.model.Employee"%>
<%@page import="springnews.model.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% LoginBean login = (LoginBean)session.getAttribute("login");
   if(login == null){response.sendRedirect("index.jsp");}
   else if(login == null || login.getLv() != 1){response.sendRedirect("fail2.jsp");} %> 

<% String username = (String)session.getAttribute("username");%>
<%-- if(login == null){response.sendRedirect("index.jsp");} --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>News On Air System : Administrator</title>
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
        <table width="999" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="999" height="131" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" alt="" width="1000" height="131"></td>
          </tr>
          <tr>
            <td bgcolor="#FFCC00"><table width="967" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="54">&nbsp;</td>
                <td width="148"><img src="imagespring/welcome.jpg" width="121" height="24"></td>
                <td width="616">ผู้ดูแลระบบ :<%= username %></td>
                <td width="123">
                    <form action="removeservlet" method="POST">
                        <input type="submit" value="ออกจากระบบ" />
                    </form>
                    </td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF"><table width="555" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="62">&nbsp;</td>
                <td width="146"><a href="addEmployee.jsp"><img src="imagespring/adminb01.jpg" width="188" height="58"></a></td>
                <td width="104"><a href="ListEmployeeServlet"><img src="imagespring/adminb02.jpg" width="188" height="58"></a></td>
                <td width="104"><a href="reporter1"><img src="imagespring/adminb03.jpg" width="188" height="58"></a></td>
                <td width="107">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><table width="734" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td colspan="5"><img src="imagespring/sysstatusbuttom.jpg" width="256" height="54"></td>
              </tr>
              <tr>
                <td width="17">&nbsp;</td>
                <td width="184"><img src="imagespring/user_5667.jpg" width="130" height="200"></td>
                <td width="152" align="center"><img src="imagespring/document-1287618_960_720.jpg" width="200" height="200"></td>
                <td width="212">&nbsp;</td>
                <td width="169">&nbsp;</td>
              </tr>
              <tr>
                <td width="17">&nbsp;</td>
                <td width="184">&nbsp;</td>
                <td width="152" align="center">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td bgcolor="#FFFFFF">&nbsp;</td>
                <td bgcolor="#FFFFFF">Member :<strong>
                  <% out.print(Employee.count_Employee_In_System()); %>
                </strong></td>
                <td align="center"><strong>News :
                    <% out.print(News.count_News_In_System()); %></strong></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF"><table width="853" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="95"><img src="imagespring/logo1.jpg" alt="" width="104" height="104"></td>
                <td width="613">บริษัท สปริงนิวส์ คอร์ปอเรชั่น จำกัด<br>
                  333 อาคารเล้าเป้งง้วน 1 ชั้น 11 ซ.เฉยพ่วง ถ.วิภาวดีรังสิต แขวงจอมพล เขตจตุจักร กทม. 10900 <br>
                  โทร. +66 (0) 2126-1111</td>
                <td width="125">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table>
    </body>
</html>
