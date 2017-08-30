/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.tomcat.jni.User.username;
import springnews.model.ConnectionDB;
import springnews.model.Employee;
import springnews.model.ErrorCk;

/**
 *
 * @author amdb2
 */
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(true);
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html");
         
        Employee emp = new Employee();
        int error = 0;
        String er1 ;
        String x = request.getParameter("empid");
        try{
            emp.setId(Integer.parseInt(request.getParameter("empid")));
            
        }catch(Exception e){
           er1 = "รหัสประจำตัวพนักงานต้องเป็นตัวเลขเท่านั้น";
            session.setAttribute("error1", er1);
            error = 1;
            response.sendRedirect("addemp2.jsp");

        }
        emp.setUsername(request.getParameter("empusername"));
        emp.setPassword(request.getParameter("emppassword"));
        
        
        
        
        String a01 = new String(request.getParameter("firstname").getBytes("ISO8859-1"),"UTF-8");
        emp.setFirstname(a01);
        String a02 = new String(request.getParameter("lastname").getBytes("ISO8859-1"),"UTF-8");
        emp.setLastname(a02);
        
        emp.setTelephone(request.getParameter("telephone"));
        emp.setEmail(request.getParameter("email"));
        emp.setLineid(request.getParameter("lineid"));       
        
        emp.setDepartmentid(Integer.parseInt(request.getParameter("departmentid")));
        
        if(emp.getUsername().equals("") || emp.getPassword().equals("")){
            String error1 = "คุณกรอกชื่อผู้ใช้งาน หรือ รหัสผ่านไม่ถูกต้อง";
            session.setAttribute("error1", error1);
            error = 1;
            response.sendRedirect("addemp2.jsp");
            
        }
        if(emp.getFirstname().equals("") || emp.getLastname().equals("")){
            String error1 = "คุณกรอกชื่อและนามสกุลไม่ถูกต้อง";
            session.setAttribute("error1", error1);
            error = 1;
            response.sendRedirect("addemp2.jsp");
            
        }
        if(Employee.check_username_not_duplicate(emp.getUsername())){
            String error1 = "Username นี้ถูกใช้ไปแล้ว กรุณาเปลี่ยน Username";
            session.setAttribute("error1", error1);
            error = 1;
            response.sendRedirect("addemp2.jsp");
            
        }
        if(Employee.check_id_not_duplicate(emp.getId())){
            String error1 = "รหัสพนักงาน นี้ถูกใช้ไปแล้ว กรุณาเปลี่ยนรหัสพนักงาน";
            session.setAttribute("error1", error1);
            error = 1;
            response.sendRedirect("addemp2.jsp");
            
        }
        
       
         

        
        if(error == 0){
        Employee.insertEmployeeSP4(emp);

        response.sendRedirect("addempfinish.jsp");
        }
    }

   
    
    

}
