package springnews.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author amdb2
 */
public class NewsManager {
    public static ArrayList<News> showNews_MainNewsOnAir(){
           ArrayList<News> news = new ArrayList<News>();
           
        try {
            
            String sql004 ="SELECT newsid,title,typenumber,type,reporterid,status,news.rdnumber,"
                    +" rdtitle,rddate,comment,cnewsid" 
                    +" FROM news , rundown , comment\n" 
                    +" Where news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" LIMIT 100;";
            
            String sql005 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,telephone,comment,cnewsid,reporterid" 
                    +" FROM news , rundown , comment , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" order by newsid LIMIT 100;";
            
            String sql006 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,date_format(rddate,'%d %m %y')as date,comment,reporterid,who_update_id" 
                    +" FROM news , rundown  , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber"
                    +" order by newsid DESC LIMIT 100;";
            
            String sql008 ="SELECT newsid,title,typenumber,type,CONCAT(nickname,' ',firstname,' ',lastname,' :tel ',telephone)as reportername,status,news.rdnumber,"
                    +" rdtitle,date,comment,cnewsid" 
                    +" FROM news , rundown , comment , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" LIMIT 100;";
            
            String sql007 ="SELECT newsid,title,typenumber,type,reporterid,status,news.rdnumber"
                           +" FROM news , rundown "
                           +"WHERE news.rdnumber = rundown.rdnumber";
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            System.out.println("connection Pass");
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql006); //default is sql005
            News n = null;
            while(rs.next()){
                n = new News(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                             rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),
                             rs.getInt(10),rs.getInt(11),rs.getInt(12)
                );
                news.add(n);
            }
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
        
    return news;
    
    }
    
      public static ArrayList<News> showNews_MainNewsOnAir_fixreporter(int reporterid){
           ArrayList<News> news = new ArrayList<News>();
        String dateAM = "'"+dateNow()+"'";
        try {
            
            String sql004 ="SELECT newsid,title,typenumber,type,reporterid,status,news.rdnumber,"
                    +" rdtitle,rddate,comment,cnewsid" 
                    +" FROM news , rundown , comment\n" 
                    +" Where news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" LIMIT 100;";
            
            String sql005 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,telephone,comment,cnewsid,reporterid" 
                    +" FROM news , rundown , comment , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" order by newsid LIMIT 100;";
            
            String sql006 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,date_format(date,'%d %b %Y')as date,comment,reporterid,who_update_id" 
                    +" FROM news , rundown  , employee" 
                    +" Where employee.id = news.reporterid and news.reporterid = "+reporterid+" and news.rdnumber = rundown.rdnumber"
                    +" and date >= "+dateAM+""
                    +" order by newsid DESC LIMIT 100;";
            
            
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            System.out.println("connection Pass");
            
            PreparedStatement stmt = conn.prepareStatement(sql006);

            

            ResultSet rs = stmt.executeQuery(sql006); //default is sql005
            News n = null;
            while(rs.next()){
                n = new News(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                             rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),
                             rs.getInt(10),rs.getInt(11),rs.getInt(12)
                );
                news.add(n);
            }
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
        
    return news;
    
    }
      
      public static ArrayList<News> showNews_MainNewsOnAir_FIndbyname(String titleName){
           ArrayList<News> news = new ArrayList<News>();
           
           String sename = "";
           sename= "%"+titleName+"%" ;
           
        try {
            
            String sql004 ="SELECT newsid,title,typenumber,type,reporterid,status,news.rdnumber,"
                    +" rdtitle,rddate,comment,cnewsid" 
                    +" FROM news , rundown , comment\n" 
                    +" Where news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" LIMIT 100;";
            
            String sql005 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,telephone,comment,cnewsid,reporterid" 
                    +" FROM news , rundown , comment , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" order by newsid LIMIT 100;";
            
            String sql006 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,date_format(date,'%d %b %Y')as date,comment,reporterid,who_update_id" 
                    +" FROM news , rundown  , employee" 
                    +" Where employee.id = news.reporterid and news.rdnumber = rundown.rdnumber"
                    +" and news.title like '"+sename+"'"
                    +" order by newsid DESC LIMIT 100;";
            //%d %m %y
            
            
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            System.out.println("connection Pass");
            
            PreparedStatement stmt = conn.prepareStatement(sql006);

            
            ResultSet rs = stmt.executeQuery(sql006); //default is sql005
            News n = null;
            while(rs.next()){
                n = new News(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                             rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),
                             rs.getInt(10),rs.getInt(11),rs.getInt(12)
                );
                news.add(n);
            }
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
        
    return news;
    
    }
      
        public static String dateNow()  {
        String day01 = "2017-04-01";
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date date2= new Date();
        return day01 = date.format(date2.getTime()-(1000*60*60*24));
    }
}
