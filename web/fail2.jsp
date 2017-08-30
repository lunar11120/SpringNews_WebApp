<%-- 
    Document   : index
    Created on : 27-Apr-2017, 00:48:11
    Author     : amdb2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        session.removeAttribute("login");
        session.removeAttribute("username");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    <style type="text/css">
    body {
	background-color: #666;
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
        <td width="999" height="131" bgcolor="#FFCC00"><img src="imagespring/banner1.jpg" alt="" width="1000" height="131"></td>
      </tr>
      <tr>
        <td bgcolor="#FFCC00">&nbsp;</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF">&nbsp;</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><table width="514" border="0" align="center" cellpadding="2" cellspacing="2">
          <tr>
            <td align="center" bgcolor="#FF3333"><strong>คุณพยายามเข้าใช้ระบบในส่วนที่คุณไม่มีสิทธิ์ กรุณาเข้าสู่ระบบอีกครั้ง</strong></td>
          </tr>
          <tr>
            <td bgcolor="#999999"><form name="form1" method="post" action="Login">
              <table width="413" border="0" align="center" cellpadding="2" cellspacing="2">
                <tr>
                  <td colspan="3"><img src="imagespring/register01.jpg" alt="" width="248" height="58"></td>
                </tr>
                <tr>
                  <td width="91">username</td>
                  <td colspan="2"><label for="username"></label>
                    <input type="text" name="username" id="username"></td>
                </tr>
                <tr>
                  <td>password</td>
                  <td colspan="2"><label for="password"></label>
                    <input type="password" name="password" id="password"></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td width="78"><input type="submit" name="submit" id="submit" value="เข้าสู่ระบบ"></td>
                  <td width="224"><input type="reset" name="cancel" id="cancel" value="ยกเลิก"></td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
              </table>
            </form></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" bgcolor="#FFFFFF">หากท่านยังไม่มี login สำหรับระบบ กรุณาติดต่อผู้ดูแลระบบ : sea@gmail.com</td>
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
