/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import springnews.model.AES;
import springnews.model.Employee;
import springnews.model.EmployeeManager;
import springnews.model.LoginBean;
import springnews.model.News;
import springnews.model.NewsManager;

/**
 *
 * @author amdb2
 */
public class LoginServlet extends HttpServlet {
    
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
                   
          HttpSession session = request.getSession(true);
         
         response.setCharacterEncoding("UTF-8");
//         response.setContentType("text/html");
//         PrintWriter out = response.getWriter();
         
         String username1 = request.getParameter("username");
         if(username1 == null){username1 = "";}
         
         String password1 = request.getParameter("password");
         if(password1 == null){password1 = "";}
         
         String key = "SpringNews";
         String password2 = AES.encrypt(password1, key);
         
         int a1 =1;
         int a2 =0;
         int a3 =0;
         int a4 =0;
         
         boolean ispass;
         LoginManager loginmanager;
         String passdecrypt;
         
 
         loginmanager = new LoginManager(username1, password1,a2);
         ispass = loginmanager.VerifyLogin();
         
         if(ispass == false){
         loginmanager = new LoginManager(username1, password2,a2);
         ispass = loginmanager.VerifyLogin();
         a4 =1;
         }

         
         
         a3 = loginmanager.getLv();
         
         
//         if(ispass == false){
//         LoginManager loginmanagerX2 = new LoginManager(username1, password2,a2);
//         ispass = loginmanagerX2.VerifyLogin();
//         }
//         
//         ispass = true;
         String username = LoginManager.checkstatusLogin(username1);
         
       
         
          
//          ArrayList<News> mainnews = new ArrayList<News>();
//          request.setAttribute("mainnews",NewsManager.showNews_MainNewsOnAir());
          
         
          
         LoginManager loginmanager2 = new LoginManager(username1, password1,a3);
         
         //new test for editlogin
         LoginBean loginmanager3 = new LoginBean();
         loginmanager3 = LoginManager.checkForEditLogin(username1);
         
          ArrayList<News> mainnews2 = new ArrayList<News>();
         request.setAttribute("mainnews2",NewsManager.showNews_MainNewsOnAir_fixreporter(loginmanager3.getId()));
         
         //Check Active Status here
         boolean isActive = false;
         try {
              isActive = LoginManager.ActiveLoginOrNot(username1);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         if(a4 ==1)
             loginmanager3.setPassword(password1);




         
         if(ispass == true & isActive == true){
             session.setAttribute("login", loginmanager2.getLogin());
             session.setAttribute("loginEdit", loginmanager3);
             session.setAttribute("username", username);
             session.setAttribute("mainnews2", mainnews2);
             

             if(loginmanager.getLv()==1){response.sendRedirect("adminpage.jsp");}
             if(loginmanager.getLv()==2){response.sendRedirect("listnews");}
             if(loginmanager.getLv()==3){response.sendRedirect("ReporterServlet");}
             if(loginmanager.getLv()==4){response.sendRedirect("McrServlet");}
             if(loginmanager.getLv()==0){response.sendRedirect("loginfail.jsp");}
         }else{
            response.sendRedirect("loginfail.jsp");
         }
  
    }

    private String toString(int empid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

}
