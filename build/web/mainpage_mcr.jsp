<%@page import="java.util.ArrayList"%>
<%@page import="springnews.model.LoginBean"%>
<%@page import="springnews.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String username = (String)session.getAttribute("username");%>
<% LoginBean login = (LoginBean)session.getAttribute("login");%>
<% LoginBean loginedit = (LoginBean)session.getAttribute("loginEdit");%>
<!DOCTYPE html>
<html>
    <head>
        <% ArrayList<News> mainnews = (ArrayList)request.getAttribute("mainnews"); %>
        <% ArrayList<Comment> commentC1 = (ArrayList)request.getAttribute("commentC1"); %>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
    body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #999;
}
    </style>
    </head>
    <body>
        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="1229" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" width="1000" height="131"></td>
          </tr>
          <tr>
            <td bgcolor="#FFCC00"><table width="980" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="71">&nbsp;</td>
                <td width="144"><img src="imagespring/welcome.jpg" width="129" height="26"></td>
                <td width="605"><%= username %></td>
                <td width="103"><form action="removeservlet" method="POST">
                        <input type="submit" value="ออกจากระบบ" />
                    </form></td>
                <td width="25">&nbsp;</td>
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
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
           <%
                  int nu01 ;
            for (int i = 0; i < mainnews.size() ; i++){
                  nu01 = i+1;
            %>  

          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          
          
          <tr>
            <td align="center" bgcolor="#FFFFFF"><table width="961" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="961" bgcolor="#FFCC00"><table width="950" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td width="68"><img src="imagespring/newssmall.jpg">
                        <% nu01 = mainnews.get(i).getNewsid();%>
                        <%--  <% out.print(nu01);%></td>  --%>
                    <td width="20"><b><font color="black"><% out.print(mainnews.get(i).getNewsid()); %><font></b></td>
                    <td width="585"><b><% out.print(  mainnews.get(i).getTitle()); %></b>
                      [<% out.print(News.changeTYPE_News(mainnews.get(i).getTypenumber())); %>]</td>
                    <td width = "81"><img src="imagespring/rundownsmall.jpg"><td>
                    <td width="158"><font size="2"><% out.print(mainnews.get(i).getRdtitle()); %></font></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td bgcolor="#666666"><table width="954" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td>&nbsp;</td>
                    <td><img src="imagespring/r01.jpg"></td>
                    <td width="390"><font color="#FFFFFF"><% out.print(mainnews.get(i).getReportername()); %></font></td>
                    <td></td>
             <form id="form1" name="form2" method="post" action="editnews"> 
          
             <input type="hidden" name="" value="" />
             <input type="hidden" name="newsid" value="<%= mainnews.get(i).getNewsid() %>" />
             <input type="hidden" name="reporterid" value="<%= mainnews.get(i).getReporterid() %>"  />
             <input type="hidden" name="username" value="<%= login.getUsername() %>"  />
             <td>
              <select name="status" id="status">
              <option selected="selected" disabled="disabled"><% out.print(News.changeStatusNews(mainnews.get(i).getStatus())); %></option>        
              <option value="1">ส่งห้องตัดต่อ</option>
              <option value="2">Rerun</option>
              <option value="3">กำลังตัดต่อ</option>
              <option value="4">ตัดต่อเรียบร้อย</option>
              <option value="5">On Air</option>
              </select> 
                 
                 <input type="submit" value="Update Status" />
                  

            </td>      
                    
                        <td><font color="#FFFFFF">status:<% out.print(News.changeStatusNews(mainnews.get(i).getStatus())); %></font> </td>
                        </form>
                    </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td><img src="imagespring/r02.jpg"></td>
                    <td><font color="#FFFFFF"><% out.print(LoginBean.getEmp_name(mainnews.get(i).getWho_update_id())); %></font></td>
                    <td>&nbsp;</td>
                    <td colspan="2"><form id="form1" name="form1" method="post" action="mcrcomment">
                      <label for="cccc"></label>
                      <input name="comm1" type="text" id="comm1" size="80" />
                    </td>
                  </tr>
                  <tr>
                    <td width="20">&nbsp;</td>
                    <td width="13">:</td>
                    <td width="180"></td>
                    <td width="188">&nbsp;</td>
                    <td width="404"><font color="#FFFFFF">date:<% out.print(mainnews.get(i).getRddate()); %></font>
                    <input type="hidden" name="username" id="username" value="<%= login.getUsername()%>" />
                        <input type="hidden" name="newsid" value="<%= mainnews.get(i).getNewsid()%>" />
                    <td width="311"><input type="submit" value="Add Comment" /> <input type="reset" value="cancel" /></td>
                    </form>
                  </tr>
                </table></td>
              </tr>
              
             <% for (int cx = 0; cx < commentC1.size() ; cx++) {
                if(nu01==commentC1.get(cx).getCnewsid()){ %>   
       
              
              <tr>
                   <td bgcolor="#FFFFFF">
                       <table width="800" border="0" align="right" cellpadding="0" cellspacing="0">
                        <td align="right" bgcolor="#CCCCCC">
                        <table width="844" border="0" cellspacing="2" cellpadding="2">
                        <td width="27">&nbsp;</td>
                        <td width="37">COMMENT</td>
                        <td width="157"><% out.print(commentC1.get(cx).getMemberid()); %></td>
                        <td width="475"><% out.print(commentC1.get(cx).getComment1()); %></td>
                        <td width="40">&nbsp;</td>
                        </table>
                        </td> 
                       </table>
                   </td>
              </tr>
              <% } %>
           <% } %>
            <% } %>   
           
          <tr>
         
          </tr>
       
        </table>

        
  
    </body>
</html>
