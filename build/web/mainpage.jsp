<%@page import="java.util.ArrayList"%>
<%@page import="springnews.model.LoginBean"%>
<%@page import="springnews.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="springnews.model.News"%>
<%@page import="springnews.model.Employee"%>
<% LoginBean login = (LoginBean)session.getAttribute("login");
   if(login == null){response.sendRedirect("index.jsp");} 
   if(login.getLv() != 2){response.sendRedirect("RemoveServlet2");} %> 
<% LoginBean loginedit = (LoginBean)session.getAttribute("loginEdit");%>
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
}
    </style>
    </head>
    <body>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="1334" align="center" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" alt="" width="1000" height="131"></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFCC00"><table width="980" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="180" align="right"><img src="imagespring/welcome.jpg" alt="" width="129" height="26"></td>
                <td width="381">ฝ่ายจัดคิวออกอากาศ :<%= username %></td>
                <td width="221" align="right"><form name="form1" method="post" action="editemp">
                  <input type="submit" name="editButton" id="editButton" value="แก้ไขข้อมูลส่วนตัว">
                </form></td>
                <td width="172"><form action="removeservlet" method="POST">
                  <input type="submit" value="ออกจากระบบ" />
                </form></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="left" bgcolor="#FFFFFF"><table width="788" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="53">&nbsp;</td>
                <td width="288"><a href="addnews.jsp"><img src="imagespring/reporterButton1.jpg" width="188" height="58"></a></td>
                <td width="187">&nbsp;</td>
                <td width="76">&nbsp;</td>
                <td width="152">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><table width="1000" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="64" bgcolor="#FFCC00">NewsID</td>
                <td width="276" bgcolor="#FFCC00">หัวข้อข่าว</td>
                <td width="112" bgcolor="#FFCC00">ประเภทข่าว</td>
                <td width="173" bgcolor="#FFCC00">ชื่อผู้สื่อข่าว</td>
                <td width="90" bgcolor="#FFCC00">วันที่</td>
                <td width="118" bgcolor="#FFCC00">status</td>
                <td width="117" bgcolor="#FFCC00">ลบข้อมูล</td>
              </tr>
            
              <%
            for (int i = 0; i < mainnews.size() ; i++){
            %>
              <tr>
                <td><font size="2"><% out.print(mainnews.get(i).getNewsid()); %></font></td>
                <td><font size="2"><% out.print(mainnews.get(i).getTitle()); %></font></td>
                <td><font size="2"><% out.print(News.changeTYPE_News(mainnews.get(i).getTypenumber())); %></font></td>
                <td><font size="2"><% out.print(mainnews.get(i).getReportername()); %></font></td>
                <td><font size="2"><% out.print(mainnews.get(i).getRddate()); %></font></td>
                <td><font size="2"><% out.print(News.changeStatusNews(mainnews.get(i).getStatus())); %></font></td>
                <td><font size="2"><a href="deletenews?deleteid=<%= mainnews.get(i).getNewsid()%>"
                       onclick="return confirm('ต้องการข่าวนี้ออกจากระบบแน่ใจหรือไม่')"
                       >Delete</a></font></td><td width="0"></font>
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
        <h1>&nbsp;</h1>
    </body>
</html>
