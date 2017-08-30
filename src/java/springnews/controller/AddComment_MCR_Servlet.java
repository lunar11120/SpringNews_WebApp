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
import springnews.model.Comment;
import springnews.model.CommentManager;
import springnews.model.LoginBean;

/**
 *
 * @author amdb2
 */
public class AddComment_MCR_Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        
        String comment1 = new String(request.getParameter("comm1").getBytes("ISO8859-1"),"UTF-8");
        String username = request.getParameter("username");
        
        int cnewsid = Integer.parseInt(request.getParameter("newsid"));
        
        int memberid = LoginBean.getEmpid(username);
        
        Comment commentsp1 = new Comment(memberid, cnewsid, comment1);
        
        CommentManager.insertComment(commentsp1);
        
        response.sendRedirect("addcommentSuccessMCR.jsp");
        

     
        }
}