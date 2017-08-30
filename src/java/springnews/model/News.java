package springnews.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author amdb2
 */
public class News {
    private int newsid;
    private String title;
    private int typenumber;
    private String type;
    private int reporterid;
    private int status;
    private int rdnumber;
    private String rdtitle;
    private String date;
    private int comment;
    private int cnewsid;
    private String reportername;
    private int num01;
    private String rddate;
    private int who_update_id;

    public News(int newsid, String title, int typenumber, String type, String reportername, int status, int rdnumber, String rdtitle, String date, int comment,  int reporterid,int who_update_id) {
        this.newsid = newsid;
        this.title = title;
        this.typenumber = typenumber;
        this.type = type;
        this.reportername = reportername;
        this.status = status;
        this.rdnumber = rdnumber;
        this.rdtitle = rdtitle;
        this.date = date;
        this.comment = comment;
        this.reporterid = reporterid;
        this.who_update_id = who_update_id;
    }

    public News(String title, int reporterid, int rdnumber) {
        this.title = title;
        this.reporterid = reporterid;
        this.rdnumber = rdnumber;
    }

    public News(int newsid, int reporterid, int status) {
        this.newsid = newsid;
        this.reporterid = reporterid;
        this.status = status;
    }

    

    public News(int newsid, String title) {
        this.newsid = newsid;
        this.title = title;
    }

    public News(int newsid, String title, int typenumber, String type) {
        this.newsid = newsid;
        this.title = title;
        this.typenumber = typenumber;
        this.type = type;
    }

    public News(int newsid, String title, int typenumber, String type, int reporterid, int status, int rdnumber) {
        this.newsid = newsid;
        this.title = title;
        this.typenumber = typenumber;
        this.type = type;
        this.reporterid = reporterid;
        this.status = status;
        this.rdnumber = rdnumber;
    }

    public News(int newsid, int reporterid, int status, int who_update_id) {
        this.newsid = newsid;
        this.reporterid = reporterid;
        this.status = status;
        this.who_update_id = who_update_id;
    }
    
    
    
    

    public News(String title) {
        this.title = title;
    }

    public News() {
    }

    public News(int rdnumber) {
        this.rdnumber = rdnumber;
    }

    

   

    public String getReportername() {
        return reportername;
    }

    public void setReportername(String reportername) {
        this.reportername = reportername;
    }

  
  

    public int getCnewsid() {
        return cnewsid;
    }

    public void setCnewsid(int cnewsid) {
        this.cnewsid = cnewsid;
    }

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTypenumber() {
        return typenumber;
    }

    public void setTypenumber(int typenumber) {
        this.typenumber = typenumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReporterid() {
        return reporterid;
    }

    public void setReporterid(int reporterid) {
        this.reporterid = reporterid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRdnumber() {
        return rdnumber;
    }

    public void setRdnumber(int rdnumber) {
        this.rdnumber = rdnumber;
    }

    public String getRdtitle() {
        return rdtitle;
    }

    public void setRdtitle(String rdtitle) {
        this.rdtitle = rdtitle;
    }

    public String getRddate() {
        return date;
    }

    public void setRddate(String rddate) {
        this.date = date;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

  public static void insertNewsSP1(News news01){
        try {
            News es1 = new News();
            es1=news01;
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

//            String sql = "INSERT INTO employee(username,password,id)"
//                    + " VALUES('edassss','sddfdvvvs',44555)";
//            
//            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
//            
//            System.out.println("update complete");
              
            //PreparedStatement test
            
            String sql = "INSERT INTO news(title,reporterid,rdnumber,typenumber,status,who_update_id)"
                    + " VALUES(?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,es1.getTitle());
            stmt.setInt(2,es1.getReporterid());
            stmt.setInt(3,es1.getRdnumber());
            stmt.setInt(4,es1.getTypenumber());
            stmt.setInt(5,es1.getStatus());
            stmt.setInt(6,es1.getWho_update_id());
            
            
            
            
            
            
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
  
  public static void insertRundownSP01(News news02){
        try {
            News es1 = new News();
            es1=news02;
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            String sql2 = "INSERT INTO news(rdnumber)"
                    + " VALUES(?)";
            java.sql.PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1,es1.getRdnumber());
            
            
            
            int i = stmt2.executeUpdate();
            System.out.println("record update ="+i);
            stmt2.close();
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
  
   public static String changeTYPE_News(int num01){
       String result = null;
       String s1 = "ข่าวเศรษฐกิจ";
       String s2 = "ข่าวการเมือง";
       String s3 = "ข่าวอาชญากรรม";
       String s4 = "ข่าวต่างประเทศ";
       String s5 = "ข่าวบันเทิง";
       String s6 = "ข่าวกีฬา";
       String s8 = "ข่าวทั่วไป";
       switch(num01){
           case(1):result = s1;break;
           case(2):result = s2;break;
           case(3):result = s3;break;
           case(4):result = s4;break;
           case(5):result = s5;break;
           case(6):result = s6;break;
           default:result = s8;
       
       }
       
       return result;
   }
   
    public static String changeStatusNews(int num01){
       String result = null;
       String s1 = "ส่งห้องตัดต่อ";
       String s2 = "Rerun";
       String s3 = "กำลังตัดต่อ";
       String s4 = "ตัดต่อเรียบร้อย";
       String s5 = "On Air";
       String s6 = "ไม่สามารถระบุสถานะได้";
       
       switch(num01){
           case(1):result = s1;break;
           case(2):result = s2;break;
           case(3):result = s3;break;
           case(4):result = s4;break;
           case(5):result = s5;break;
           default:result = s6;
       
       }
       
       return result;
   }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public static void ChangeStatusnews_X91_SPR(News new01){
               News es01 = new News(0, 0, 0, 0);
               es01 = new01;
        try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");


            
            String sql = "UPDATE news SET status=? "
                    + " WHERE newsid = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,es01.getStatus());
            stmt.setInt(2,es01.getNewsid());
            

            int i = stmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("Delete Employee "+ex.getMessage());
        }
    }
    
    public static void ChangeWhoupdate(News new01){
               News es01 = null;
               es01 = new01;
        try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            
            
            String sql2 = "UPDATE news SET who_update_id = ? "
                    + " WHERE newsid = ?";
            java.sql.PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1,es01.getWho_update_id());
            stmt2.setInt(2,es01.getNewsid());
            
            int i = stmt2.executeUpdate();
            
            stmt2.close();
            conn.close();
            
            
        } catch (Exception ex) {
            System.out.println("Delete Employee "+ex.getMessage());
        }
    }

    public int getWho_update_id() {
        return who_update_id;
    }

    public void setWho_update_id(int who_update_id) {
        this.who_update_id = who_update_id;
    }
    
    public static String findNewsTitle(int newsid){
        String newstitle = "";
        int id = newsid;
        
         try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");


            
            String sql = "SELECT title FROM news "
                    + " WHERE newsid = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){newstitle = rs.getString(1);}
            
            

            
            
        } catch (Exception ex) {
            System.out.println("NewstitLE ERROR "+ex.getMessage());
        }
        
        
        
        return newstitle;
    }
    
    public static String findTelephone_Number(int reporterid){
        String telephone = "";
        int id = reporterid;
        
         try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");


            
            String sql = "SELECT telephone FROM employee "
                    + " WHERE id = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){telephone = rs.getString(1);}
            
            

            
            
        } catch (Exception ex) {
            System.out.println("NewstitLE ERROR "+ex.getMessage());
        }
        
        
        
        return telephone;
    }

public static int count_News_In_System(){
        int countNews = 12;
        
        
         try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            String sql = "SELECT count(newsid) FROM news ";
            Statement stmt = conn.createStatement();
            

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){countNews = rs.getInt(1);}
            
            

            
            
        } catch (Exception ex) {
            System.out.println("NewstitLE ERROR "+ex.getMessage());
        }
        
        
        
        return countNews;
    }

    public static String show_System_Time_News_OnAir(){
        String time01 = "";
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:MM"); 
        
        Calendar now = Calendar.getInstance();
        time01 = dateFormat.format(now.getTime());
        
        return time01;
    }
    
    public static void delete_NEWS_SP4(int id){
        try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

//            String sql = "INSERT INTO employee(username,password,id)"
//                    + " VALUES('edassss','sddfdvvvs',44555)";
//            
//            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
//            
//            System.out.println("update complete");
              
            //PreparedStatement test
            
            String sql = "DELETE FROM news "
                    + " WHERE newsid = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("Delete Employee "+ex.getMessage());
        }
    }
    
    
}
