<%-- 
    Document   : addnews
    Created on : 28-Apr-2017, 21:23:26
    Author     : amdb2
--%>

<%@page import="springnews.model.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="springnews.model.News"%>
<%@page import="springnews.model.Employee"%>
<% LoginBean login = (LoginBean)session.getAttribute("login");
   if(login == null){response.sendRedirect("index.jsp");} 
   if(login.getLv() != 2){response.sendRedirect("RemoveServlet2");} %> 
<% String username = (String)session.getAttribute("username");%>
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
            <td bgcolor="#FFCC00"><table width="967" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="54">&nbsp;</td>
                <td width="148"><img src="imagespring/welcome.jpg" alt="" width="121" height="24"></td>
                <td width="616">ฝ่ายจัดคิวออกอากาศ : <%= username %></td>
                <td width="123"><form action="removeservlet" method="POST">
                  <input type="submit" value="ออกจากระบบ" />
                </form></td>
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
            <td bgcolor="#FFFFFF"><table width="1002" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="928" bgcolor="#CCCCCC"><form name="frm" action="AddNews" method="POST">
                  <table width="876" border="0" cellspacing="2" cellpadding="2">
                      <tr>
                        <td colspan="8" bgcolor="#CCCCCC">INSERT RUNDOWN : เพิ่มข่าวเข้าสู่คิวออกอากาศ</td>
                    </tr>
                      <tr>
                        <td colspan="8" bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td width="116" bgcolor="#CCCCCC">ชื่อ Rundown</td>
                        <td colspan="3" bgcolor="#CCCCCC"><select name="rdnumber" id="rdnumber">
                          <option value="1">ปรากฏการณ์ข่าวจริง 18.00 น.</option>
                          <option value="2">ปรากฏการณ์ข่าวจริง 06.00 น.</option>
                          <option value="3">ปรากฏการณ์ข่าวจริง เที่ยงวัน</option>
                          <option value="4">Breaking News</option>
                          <option value="5">ข่าวไม่ระบุเวลาออกอากาศ</option>
                        </select></td>
                        <td width="135" bgcolor="#CCCCCC">&nbsp;</td>
                        <td width="124" bgcolor="#CCCCCC">&nbsp;</td>
                        <td width="133" bgcolor="#CCCCCC">&nbsp;</td>
                        <td width="30" bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                        <td colspan="3" bgcolor="#CCCCCC">&nbsp;</td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td bgcolor="#CCCCCC">NEWS</td>
                        <td colspan="3" bgcolor="#CCCCCC">หัวข้อข่าว : News Title</td>
                        <td bgcolor="#CCCCCC">รหัสประจำตัวผู้สื่อข่าว</td>
                        <td bgcolor="#CCCCCC">ประเภทข่าว</td>
                        <td bgcolor="#CCCCCC">STATUS </td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td bgcolor="#CCCCCC">Number 1</td>
                        <td colspan="3" bgcolor="#CCCCCC"><input type="text" name="newstitle" id="newstitle" size="50" /></td>
                        <td bgcolor="#CCCCCC"><input type="text" name="reporterid" id="reporterid" size="20" /></td>
                        <td bgcolor="#CCCCCC"><select name="type" id="type">
                          <option value="1">ข่าวเศรษฐกิจ</option>
                          <option value="2">ข่าวการเมือง</option>
                          <option value="3">ข่าวอาชญากรรม</option>
                          <option value="4">ข่าวต่างประเทศ</option>
                          <option value="5">ข่าวบันเทิง</option>
                          <option value="6">ข่าวกีฬา</option>
                          <option value="7">ข่าวทั่วไป</option>
                        </select></td>
                        <td bgcolor="#CCCCCC"><select name="status" id="status">
                          <option value="1">ส่งห้องตัดต่อ</option>
                          <option value="2">Rerun</option>
                          <option value="3">กำลังตัดต่อ</option>
                          <option value="4">ตัดต่อเรียบร้อย</option>
                          <option value="5">On Air</option>
                        </select></td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td bgcolor="#CCCCCC">Number 2</td>
                        <td colspan="3" bgcolor="#CCCCCC"><input type="text" name="newstitle2" id="newstitle2" size="50" /></td>
                        <td bgcolor="#CCCCCC"><input type="text" name="reporterid2" id="reporterid2" size="20" /></td>
                        <td bgcolor="#CCCCCC"><select name="type2" id="type2">
                          <option value="1">ข่าวเศรษฐกิจ</option>
                          <option value="2">ข่าวการเมือง</option>
                          <option value="3">ข่าวอาชญากรรม</option>
                          <option value="4">ข่าวต่างประเทศ</option>
                          <option value="5">ข่าวบันเทิง</option>
                          <option value="6">ข่าวกีฬา</option>
                          <option value="7">ข่าวทั่วไป</option>
                        </select></td>
                        <td bgcolor="#CCCCCC"><select name="status2" id="status2">
                          <option value="1">ส่งห้องตัดต่อ</option>
                          <option value="2">Rerun</option>
                          <option value="3">กำลังตัดต่อ</option>
                          <option value="4">ตัดต่อเรียบร้อย</option>
                          <option value="5">On Air</option>
                        </select></td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td bgcolor="#CCCCCC">Number 3</td>
                        <td colspan="3" bgcolor="#CCCCCC"><input type="text" name="newstitle3" id="newstitle3" size="50" /></td>
                        <td bgcolor="#CCCCCC"><input type="text" name="reporterid3" id="reporterid3" size="20" /></td>
                        <td bgcolor="#CCCCCC"><select name="type3" id="type3">
                          <option value="1">ข่าวเศรษฐกิจ</option>
                          <option value="2">ข่าวการเมือง</option>
                          <option value="3">ข่าวอาชญากรรม</option>
                          <option value="4">ข่าวต่างประเทศ</option>
                          <option value="5">ข่าวบันเทิง</option>
                          <option value="6">ข่าวกีฬา</option>
                          <option value="7">ข่าวทั่วไป</option>
                        </select></td>
                        <td bgcolor="#CCCCCC"><select name="status3" id="status3">
                          <option value="1">ส่งห้องตัดต่อ</option>
                          <option value="2">Rerun</option>
                          <option value="3">กำลังตัดต่อ</option>
                          <option value="4">ตัดต่อเรียบร้อย</option>
                          <option value="5">On Air</option>
                        </select></td>
                        <td bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="8" bgcolor="#CCCCCC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="8" bgcolor="#CCCCCC"><table width="555" border="0" cellspacing="2" cellpadding="2">
                          <tr>
                            <td width="91">&nbsp;</td>
                            <td width="106"><input type="submit" value="Add Rundown"></td>
                            <td width="199"><input type="reset" value="cancel"></td>
                            <td width="133">&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                  </table>
                </form></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><a href="listnews"><img src="imagespring/report04.jpg" width="188" height="58"></a></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
        </table>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <h1>ADD EMPLOYEE PAGE</h1>
        <h1>Welcome,<%= login.getUsername() %></h1>
<br>
        <br>


    </body>
</html>
