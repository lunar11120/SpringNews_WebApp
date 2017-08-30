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
import springnews.model.Employee;

/**
 *
 * @author amdb2
 */
public class EditActiveEmployeeServlet extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         
         response.setContentType("text/html");
         String test1 = request.getParameter("activeid");
         String test2 = test1.trim();
         int id = (int)(Integer.parseInt(test2));
         
         Employee.ActiveEmployee(id);
         
         

         
         //response.sendRedirect("deletesuccess.jsp");
         response.sendRedirect("ListEmployeeServlet");
    }


}
