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
import springnews.model.AES;
import springnews.model.Employee;

/**
 *
 * @author amdb2
 */
public class EditEmpServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html");
         
        Employee emp = new Employee();
        int error = 0;
        String er1 ;
        String x = request.getParameter("empidold");
        int id = Integer.parseInt(x);
        
        String y = request.getParameter("empid");
        int idnew = Integer.parseInt(y);
        
        String dept = request.getParameter("departmentid");
        int deptid = Integer.parseInt(dept);
        
        String a01 = new String(request.getParameter("firstname").getBytes("ISO8859-1"),"UTF-8");
        emp.setFirstname(a01);
        String a02 = new String(request.getParameter("lastname").getBytes("ISO8859-1"),"UTF-8");
        emp.setLastname(a02);
        
        String key = "SpringNews";
        String emppassword = request.getParameter("emppassword");
        String encryptpassword = AES.encrypt(emppassword, key);
        
        
        emp.setUsername(request.getParameter("empusername"));
        emp.setPassword(encryptpassword);
        emp.setId(idnew);
        emp.setFirstname(a01);
        emp.setLastname(a02);
//        emp.setTelephone(request.getParameter("telephone"));
//        emp.setEmail(request.getParameter("email"));
//        emp.setLineid(request.getParameter("lineid"));
//        emp.setDepartmentid(deptid);
        
        Employee.UpdateEmployeeSP1(emp,id);
        
        
        
        if(error == 0)
        response.sendRedirect("loginAgain.jsp");
        
        if(error != 0)
        response.sendRedirect("test.jsp");
    }

   

    
}

   
    
    
   


