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
import springnews.model.Employee;
import springnews.model.EmployeeManager;
import springnews.model.Department;

/**
 *
 * @author amdb2
 */
public class ListEmployeeServlet extends HttpServlet {
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          ArrayList<Employee> maintest = new ArrayList<Employee>();
          request.setAttribute("maintest",EmployeeManager.showFirstPage_admin());
          

            
          RequestDispatcher rd = request.getRequestDispatcher("listEmployee.jsp");
//            request.setAttribute("a1", r2);
//            request.setAttribute("a2", r3);
            rd.forward(request, response);
        
  
         
         
//         EmployeeManager empmcr3 = new EmployeeManager();
//         request.setAttribute("listdept3", empmcr3.getAllEmployee_reporter());
//         
//         ArrayList<Employee> e_reporter = new ArrayList<>();
//                 e_reporter = (ArrayList)empmcr3.getAllEmployee_reporter();
//         request.setAttribute("n01", e_reporter.get(1).getFirstname());
//         request.setAttribute("n02", 345566666);
//         response.sendRedirect("listEmployee.jsp");
//         
        
    }
    
}
