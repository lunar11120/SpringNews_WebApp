package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginfail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("    body {\n");
      out.write("\tbackground-color: #666;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table width=\"1067\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">SPRING NEWS BANNER : NEWS ON AIR TRACKING SYSTEM</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\"><table width=\"514\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"2\">\n");
      out.write("              <tr>\n");
      out.write("                <td bgcolor=\"#CCCCCC\"><form name=\"form1\" method=\"post\" action=\"Login\">\n");
      out.write("                  <table width=\"413\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"2\">\n");
      out.write("                     <tr>\n");
      out.write("                      <td colspan=\"3\"><font color=\"red\">ชื่อ หรือ รหัสผ่านไม่ถูกต้อง กรุณาลองเข้าระบบใหม่อีกครั้ง</font></td>\n");
      out.write("                    </tr>\n");
      out.write("                      <tr>\n");
      out.write("                      <td colspan=\"3\">สมาชิกเข้าสู่ระบบ</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td width=\"91\">username</td>\n");
      out.write("                      <td colspan=\"2\"><label for=\"username\"></label>\n");
      out.write("                      <input type=\"text\" name=\"username\" id=\"username\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td>password</td>\n");
      out.write("                      <td colspan=\"2\"><label for=\"password\"></label>\n");
      out.write("                      <input type=\"password\" name=\"password\" id=\"password\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td>&nbsp;</td>\n");
      out.write("                      <td width=\"78\"><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"เข้าสู่ระบบ\"></td>\n");
      out.write("                      <td width=\"224\"><input type=\"reset\" name=\"cancel\" id=\"cancel\" value=\"ยกเลิก\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td>&nbsp;</td>\n");
      out.write("                      <td>&nbsp;</td>\n");
      out.write("                      <td>&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                  </table>\n");
      out.write("                </form></td>\n");
      out.write("              </tr>\n");
      out.write("            </table></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td bgcolor=\"#FFFFFF\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("        </table>\n");
      out.write("        <h1>&nbsp;</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
