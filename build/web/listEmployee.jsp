<%-- 
    Document   : listEmployee
    Created on : 27-Apr-2017, 18:59:51
    Author     : amdb2
--%>

<%@page import="springnews.model.LoginBean"%>
<%@page import="springnews.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% LoginBean login = (LoginBean)session.getAttribute("login");
   if(login == null){response.sendRedirect("index.jsp");}
   else if(login == null || login.getLv() != 1){response.sendRedirect("fail2.jsp");} %> 
<% String username = (String)session.getAttribute("username");%>
<% ArrayList<Employee> maintest = (ArrayList)request.getAttribute("maintest"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Check Employee</title>
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
            <td align="center" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" width="1000" height="131"></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFCC00"><table width="980" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="180" align="right"><img src="imagespring/welcome.jpg" width="129" height="26"></td>
                <td width="296">ผู้ดูแลระบบ :<%= username %></td>
                <td width="306"></td>
                <td width="172">
                    <form action="removeservlet" method="POST">
                        <input type="submit" value="ออกจากระบบ" />
                    </form></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="left" bgcolor="#FFFFFF"><table width="788" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="63">&nbsp;</td>
                <td width="239"><a href="adminpage.jsp">Back to Admin page</a></td>
                <td width="151">&nbsp;</td>
                <td width="151">&nbsp;</td>
                <td width="152">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><table width="900" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="90" bgcolor="#FFCC00">ID</td>
                <td width="191" bgcolor="#FFCC00">ชื่อ</td>
                <td width="227" bgcolor="#FFCC00">นามสกุล</td>
                <td width="196" bgcolor="#FFCC00">Email Address</td>
                <td width="84" bgcolor="#FFCC00">Status</td>
                <td width="164" bgcolor="#FFCC00">Change Status</td>
              </tr>
               <%
            for (int i = 0; i < maintest.size() ; i++){
            %>
              <tr>
                <td><% out.print(maintest.get(i).getId()); %></td>
                <td><% out.print(maintest.get(i).getFirstname()); %></td>
                <td><% out.print(maintest.get(i).getLastname()); %></td>
                <td><% out.print(maintest.get(i).getEmail()); %></td>
                <td><% out.print(maintest.get(i).getActive()); %></td>
                <td><table width="145" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><a href="active?activeid=<%= maintest.get(i).getId()%>"
                       onclick="return confirm('Active IDพนักงาน แน่ใจหรือไม่')"
                       >Active </a> 
                    
                    <td><a href="delete?deleteid=<%= maintest.get(i).getId()%>"
                       onclick="return confirm('ต้องการ Disable แน่ใจหรือไม่')"
                       >Disable</a></td>
                  </tr>
                </table></td>
              </tr>
              <% } %>
            </table></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><table width="853" border="0" cellspacing="2" cellpadding="2">
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
        <p><br>
        </p>
<% String warning = (String)session.getAttribute("warning");
           if(warning != null){
           session.removeAttribute("warning");
        %>
        <script language="javascript">
            alert('<%= warning %>');
        </script>
        <% } %>
        
                   
   
        
         
    </body>
</html>
