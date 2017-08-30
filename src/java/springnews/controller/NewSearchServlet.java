/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import springnews.model.Comment;
import springnews.model.CommentManager;
import springnews.model.LoginBean;
import springnews.model.News;
import springnews.model.NewsManager;

/**
 *
 * @author amdb2
 */
public class NewSearchServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
     String form2 = "";     
         try {
             News news01 = new News();

            String title01 = new String(request.getParameter("form3").getBytes("ISO8859-1"), "UTF-8");
            news01.setTitle(title01);
            form2 = news01.getTitle();
           
       } catch (Exception e) {
           
          form2 = "กองปราบ";
       }
         
        
        


           
           ArrayList<News> mainnews = new ArrayList<News>();
           request.setAttribute("mainnews",NewsManager.showNews_MainNewsOnAir_FIndbyname(form2));
           
           
           
           ArrayList<Comment> commentC1 = new ArrayList<Comment>();
           request.setAttribute("commentC1", CommentManager.Comment_ListNewsOnAir());
           
           
           RequestDispatcher rd = request.getRequestDispatcher("mainpagereporter_search.jsp");
           
           rd.forward(request, response);
        
    }

 
   
}
