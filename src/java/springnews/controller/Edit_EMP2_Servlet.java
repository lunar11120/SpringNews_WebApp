/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import springnews.model.LoginBean;

/**
 *
 * @author amdb2
 */
@WebServlet(name = "Edit_EMP2_Servlet", urlPatterns = {"/editreport2"})
public class Edit_EMP2_Servlet extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");

        int memberid = LoginBean.getEmpid(username);
        
        
        
        response.sendRedirect("edit_emp2.jsp");
        

     
        }


}
