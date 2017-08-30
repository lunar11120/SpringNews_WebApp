/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amdb2
 */
public class LoginServlet extends HttpServlet {
    
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         HttpSession session = request.getSession(true);
         
         String username1 = request.getParameter("username");
         if(username1 == null){username1 = "";}
         
         String password1 = request.getParameter("password");
         if(password1 == null){password1 = "";}
         
         LoginManager loginmanager = new LoginManager(username1,password1);
         boolean ispass = loginmanager.VerifyLogin();
         
         if(ispass == true){
             session.setAttribute("login", loginmanager.getLogin());
             if(loginmanager.getLv()==1){response.sendRedirect("adminpage.jsp");}
             if(loginmanager.getLv()==2){response.sendRedirect("mainpage.jsp");}
             if(loginmanager.getLv()==0){response.sendRedirect("loginfail.jsp");}
         }else{
            response.sendRedirect("loginfail.jsp");
         }
  
    }
 

}
