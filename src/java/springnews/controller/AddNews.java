/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import springnews.model.Employee;
import springnews.model.News;
import java.util.Date;

/**
 *
 * @author amdb2
 */
public class AddNews extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        int check01 = 0;
        int error = 0;
        int ok3 = 0;
        int ok2 = 0;
        int ok = 0;
        int havenews3 = 0;
        int havenews2 = 0;
        String er1;
        
        
        String reporterid3 = request.getParameter("reporterid3");
        String newstitle3 = request.getParameter("newstitle3");
        String newstitle2 = request.getParameter("newstitle2");
        String reporterid2 = request.getParameter("reporterid2");
        if (newstitle3.equals("") & reporterid3.equals(""))

            havenews3 = 1;
        
        if (newstitle2.equals("") & reporterid2.equals(""))

            havenews2 = 1;
        

        

 

        String newstitle = request.getParameter("newstitle");
        if (newstitle == null || newstitle.equals(""))
            error = 1;
        
        

        String reporterid = request.getParameter("reporterid");
        if (reporterid == null || reporterid.equals(""))
            error = 1;
        
        try {
            
            int i;
            i = Integer.parseInt(reporterid);
        } catch (Exception e) {
            error = 4;
        }
        
        
       
        
        if(havenews2 < 1){
         try {
            
            int i;
            i = Integer.parseInt(reporterid2);
        } catch (Exception e) {
            error = 5;
        }
        if(havenews2 < 1){

        if (newstitle2 == null || newstitle2.equals(""))
            error = 2;

        if (reporterid2 == null || reporterid2.equals(""))
            error = 2;


        }
         
        
        }
        
          if(havenews3 < 1){
         try {
            
            int i;
            i = Integer.parseInt(reporterid3);
        } catch (Exception e) {
            error = 6;
        }
         
        
        }
          
         if(havenews3 < 1 ){
        if (reporterid3 == null || reporterid3.equals(""))
            error = 2;
        
        if (newstitle3== null || newstitle3.equals(""))
            error = 2;
        
        }
        
        
 

        
        
        

        



        try {
            News news01 = new News();

            String title01 = new String(request.getParameter("newstitle").getBytes("ISO8859-1"), "UTF-8");
            news01.setTitle(title01);

            news01.setReporterid(Integer.parseInt(request.getParameter("reporterid")));
            //news01.setRdnumber(Integer.parseInt(request.getParameter("rdnumber")));
            int i1 = Integer.parseInt(request.getParameter("rdnumber"));
            int type = Integer.parseInt(request.getParameter("type"));
            int status = Integer.parseInt(request.getParameter("status"));
            news01.setRdnumber(i1);
            news01.setTypenumber(type);
            news01.setStatus(status);

            News.insertNewsSP1(news01);

        } catch (Exception e) {

        }

        try {
            News news02 = new News();
            String title02 = new String(request.getParameter("newstitle2").getBytes("ISO8859-1"), "UTF-8");
            news02.setTitle(title02);

            news02.setReporterid(Integer.parseInt(request.getParameter("reporterid2")));
            //news01.setRdnumber(Integer.parseInt(request.getParameter("rdnumber")));
            int i2 = Integer.parseInt(request.getParameter("rdnumber"));
            int type2 = Integer.parseInt(request.getParameter("type2"));
            int status2 = Integer.parseInt(request.getParameter("status2"));
            news02.setRdnumber(i2);
            news02.setTypenumber(type2);
            news02.setStatus(status2);
            News.insertNewsSP1(news02);

        } catch (Exception e) {
        }

        try {

            News news03 = new News();
            String title03 = new String(request.getParameter("newstitle3").getBytes("ISO8859-1"), "UTF-8");
            news03.setTitle(title03);

            news03.setReporterid(Integer.parseInt(request.getParameter("reporterid3")));
            //news01.setRdnumber(Integer.parseInt(request.getParameter("rdnumber")));
            int i3 = Integer.parseInt(request.getParameter("rdnumber"));
            int type3 = Integer.parseInt(request.getParameter("type3"));
            int status3 = Integer.parseInt(request.getParameter("status3"));
            news03.setRdnumber(i3);
            news03.setTypenumber(type3);
            news03.setStatus(status3);

            News.insertNewsSP1(news03);

        } catch (Exception e) {

        }

        //News.insertRundownSP01(news02);
        //response.sendRedirect("listnews");
        
        switch(error){
            case 1 : er1 = "กรุณากรอกข้อมูลข่าวอย่างน้อย 1 ข่าว" ; break;
            case 2 : er1 = "กรุณากรอกข้อมูลข่าวให้ครบถ้วน" ; break;
            case 3 : er1 = "มันเกิดข้อผิดลาดไงหละๆๆๆๆ 33" ; break;
            case 4 : er1 = "รหัสประจำตัวผู้สื่อข่าวต้องใส่เป็นตัวเลขเท่านั้น" ; break;
            case 5 : er1 = "ข่าวลำดับ 2 รหัสประจำตัวผู้สื่อข่าวต้องใส่เป็นตัวเลขเท่านั้น" ; break;
            case 6 : er1 = "ข่าวลำดับ 3 รหัสประจำตัวผู้สื่อข่าวต้องใส่เป็นตัวเลขเท่านั้น" ; break;
            default : er1 = "มันไม่มีอะไรผิดนี่หว่า";
        }
        
       
        
        if(error > 0){
            session.setAttribute("ckerror", er1);
        response.sendRedirect("addnews2.jsp"); }
        
        
         if(error == 0)
        response.sendRedirect("addNews_success.jsp");
        
    }

}
