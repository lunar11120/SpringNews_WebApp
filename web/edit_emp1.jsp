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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>News On Air System : Add Employee</title>
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
        <table width="999" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="999" height="131" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" alt="" width="1000" height="131"></td>
          </tr>
          <tr>
            <td bgcolor="#FFCC00"><table width="967" border="0" cellspacing="2" cellpadding="2">
              <tr>
                <td width="54">&nbsp;</td>
                <td width="148"><img src="imagespring/welcome.jpg" alt="" width="121" height="24"></td>
                <td width="616">:<%= username %></td>
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
            <td align="center" bgcolor="#FFFFFF"><img src="imagespring/redit03.jpg" width="175" height="39"></td>
          </tr>
          <tr>
            <td bgcolor="#CCCCCC"><form name="frm" action="editemp2" method="POST">
              <table width="903" border="0" cellspacing="2" cellpadding="2">
                <tr>
                  <td colspan="6"><strong>เพิ่มข้อมูลพนักงาน</strong></td>
                </tr>
                <tr>
                  <td width="14">&nbsp;</td>
                  <td width="171">&nbsp;</td>
                  <td width="147">&nbsp;</td>
                  <td width="178">&nbsp;</td>
                  <td width="123">&nbsp;</td>
                  <td width="232">&nbsp;</td>
                </tr>
                <tr>
                  <td bgcolor="#CCCCCC">&nbsp;</td>
                  <td>Username :</td>
                  <td><input type="text" name="empusername" id="empusername" value="<%= loginedit.getUsername() %>" size="24" /></td>
                  <td>*</td>
                  <td>เบอร์โทรศัพท์ :</td>
                  <td><label for="telephone"></label>
                  <input type="text" name="telephone" value="<%= loginedit.getTelePhone() %>" id="telephone"></td>
                </tr>
                <tr>
                  <td bgcolor="#CCCCCC">&nbsp;</td>
                  <td>Password :</td>
                  <td><input type="text" name="emppassword" id="emppassword" value="<%= loginedit.getPassword() %>" size="24" /></td>
                  <td>*</td>
                  <td>email address :</td>
                  <td><label for="email"></label>
                  <input type="text" name="email" value="<%= loginedit.getEmail() %>" id="email"></td>
                </tr>
                <tr>
                  <td bgcolor="#CCCCCC">&nbsp;</td>
                  <td>รหัสประจำตัวพนักงาน :</td>
                  <td>
                      <input type="number" name="empid" id="empid" value="<%= loginedit.getId() %>" size="24" />
                      <input type="hidden" name="empidold" id="empidold" value="<%= loginedit.getId() %>" />
                  </td>
                  <td>* <font size="2">(กรอกเป็นตัวเลขเท่านั้น)</td>
                  <td>line id :</td>
                  <td><label for="lineid"></label>
                  <input type="text" name="lineid" value="<%= loginedit.getLineid() %>" id="lineid"></td>
                </tr>
                <tr>
                  <td bgcolor="#CCCCCC">&nbsp;</td>
                  <td>ชื่อ :</td>
                  <td><input name="firstname" type="text" id="firstname2" value="<%= loginedit.getFullname() %>" size="24"></td>
                  <td>*</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td bgcolor="#CCCCCC">&nbsp;</td>
                  <td>นามสกุล :</td>
                  <td><input name="lastname" type="text" id="lastname" value="<%= loginedit.getSurname() %>" size="24"></td>
                  <td>*</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td bgcolor="#CCCCCC">&nbsp;</td>
                  <td>แผนก :</td>
                  <td colspan="2"><select name="departmentid" value="<%= loginedit.getDeptid() %>" id="departmentid">
                    <option value="2">บรรณาธิการข่าว</option>
                    <option value="3">ผู้สื่อข่าว</option>
                    <option value="4">เจ้าหน้าที่ตัดต่อ/ออกอากาศ</option>
                  </select></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td colspan="2">&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td align="right"><input type="submit" value="save new user login"></td>
                  <td><input type="reset" value="cancel"></td>
                  <td colspan="2">กรุณากรอกทุกช่องที่มีเครื่องหมาย *</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
              </table>
            </form></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" bgcolor="#FFFFFF"><a href="listnews"><img src="imagespring/backtoQ.jpg" width="188" height="58"></a></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF">&nbsp;</td>
          </tr>
        </table>
    </body>
</html>
