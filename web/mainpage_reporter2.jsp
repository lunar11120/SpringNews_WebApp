<%@page import="java.util.ArrayList"%>
<%@page import="springnews.model.LoginBean"%>
<%@page import="springnews.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String username = (String)session.getAttribute("username");%>
<% LoginBean login = (LoginBean)session.getAttribute("login");
   if(login == null){response.sendRedirect("index.jsp");}
   else if(login == null || login.getLv() != 1){response.sendRedirect("fail2.jsp");} %> 
<!DOCTYPE html>
<html>
    <head>
        <% ArrayList<News> mainnews = (ArrayList)request.getAttribute("mainnews"); %>
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
        <table width="999" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="999" height="131" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" alt="" width="1000" height="131"></td>
          </tr>
          <tr>
            <td bgcolor="#FFCC00"><table width="967" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="54">&nbsp;</td>
                <td width="148"><img src="imagespring/welcome.jpg" alt="" width="121" height="24"></td>
                <td width="616">ผู้ดูแลระบบ :<%= username %></td>
                <td width="123"><form action="removeservlet" method="POST">
                  <input type="submit" value="ออกจากระบบ" />
                </form></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF"><table width="788" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="55">&nbsp;</td>
                <td width="247"><a href="adminpage.jsp">Back to Admin page</a></td>
                <td width="151">&nbsp;</td>
                <td width="151">&nbsp;</td>
                <td width="152">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="left" bgcolor="#FFFFFF"><img src="imagespring/newsReport.jpg" width="307" height="55"></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><table border="0" cellpadding="2" cellspacing="3">
              <tr>
                <td bgcolor="#FFCC00">ลำดับ</td>
                <td bgcolor="#FFCC00">หัวข้อข่าว</td>
                <td bgcolor="#FFCC00">ประเภทข่าว</td>
                <td bgcolor="#FFCC00">ผู้สื่อข่าว</td>
                <td bgcolor="#FFCC00">วันที่</td>
                <td bgcolor="#FFCC00">สถานะของข่าว</td>
              </tr>
              <%
            for (int i = 0; i < mainnews.size() ; i++){
            %>

              <tr>
                <td bgcolor="#FFFFFF"><% out.print(mainnews.get(i).getNewsid()); %></td>
                <td bgcolor="#FFFFFF"><% out.print(mainnews.get(i).getTitle()); %></td>
                <td bgcolor="#FFFFFF"><% out.print(News.changeTYPE_News(mainnews.get(i).getTypenumber())); %></td>
                <td bgcolor="#FFFFFF"><% out.print(mainnews.get(i).getReportername()); %></td>
                <td bgcolor="#FFFFFF"><% out.print(mainnews.get(i).getRdtitle()); %></td>
                <td bgcolor="#FFFFFF"><% out.print(News.changeStatusNews(mainnews.get(i).getStatus())); %></td>
              </tr>
              <% } %>
            </table></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><a href="adminpage.jsp"><img src="imagespring/adminb04.jpg" alt="" width="226" height="70"></a></td>
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
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
        </table>
        <h1><br>
        </h1>
</body>
</html>
