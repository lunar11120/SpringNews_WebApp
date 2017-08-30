/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import springnews.model.LoginBean;
import springnews.model.News;
import springnews.model.SMS_send_to_THSMS;

/**
 *
 * @author amdb2
 */
public class EditNewsStatusServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html");
        

        News news01 = new News();
        
        int reporterid = Integer.parseInt(request.getParameter("reporterid"));
        int newsid = Integer.parseInt(request.getParameter("newsid"));

          
        news01.setNewsid(Integer.parseInt(request.getParameter("newsid")));
        news01.setReporterid(Integer.parseInt(request.getParameter("reporterid")));
        news01.setStatus(Integer.parseInt(request.getParameter("status")));
        
        
        
        String username = request.getParameter("username");
        int whoupdateid = LoginBean.getEmpid(username);
        
        news01.setWho_update_id(whoupdateid);
        
        News.ChangeStatusnews_X91_SPR(news01);
        
        int ck01 = Integer.parseInt(request.getParameter("status"));
        
        if(ck01 == 4) {
            SMS_send_to_THSMS.send_SMS_NOW(reporterid, newsid);
            News.ChangeWhoupdate(news01);
        }
        

        if(ck01 <= 3){ News.ChangeWhoupdate(news01);}
        
         
  
        response.sendRedirect("editnews_finish.jsp");
    }
    
}
