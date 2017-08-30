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
import springnews.model.News;
import springnews.model.NewsManager;

/**
 *
 * @author amdb2
 */
public class ReportAdminListNews extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         
     
          

            
         
        
           ArrayList<News> mainnews = new ArrayList<News>();
           request.setAttribute("mainnews",NewsManager.showNews_MainNewsOnAir());
           
           
           
           RequestDispatcher rd = request.getRequestDispatcher("mainpage_reporter2.jsp");
           
           rd.forward(request, response);
        
    }

 
   
}
