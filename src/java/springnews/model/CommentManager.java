package springnews.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amdb2
 */
public class CommentManager {
    public static ArrayList<Comment> Comment_ListNewsOnAir(){
           ArrayList<Comment> commentC1 = new ArrayList<Comment>();
           
        try {
            
            String sql004 ="SELECT commentid,memberid,cnewsid,comment1"
                    
                    +" FROM comment" 
                  //  +" Where news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" LIMIT 100;";
            
            String sql005 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,telephone,comment,cnewsid,reporterid" 
                    +" FROM news , rundown , comment , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber and news.comment=comment.cnewsid"
                    +" order by newsid LIMIT 100;";
            
            String sql006 ="SELECT newsid,title,typenumber,type,CONCAT(firstname,' ',lastname)as reportername,status,news.rdnumber,"
                    +" rdtitle,telephone,comment,cnewsid,reporterid" 
                    +" FROM news , rundown , comment , employee" 
                    +" Where employee.id =news.reporterid and news.rdnumber = rundown.rdnumber"
                    +" order by newsid LIMIT 100;";
            
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
            ResultSet rs = stmt.executeQuery(sql004); //default is sql004
            Comment c = null;
            while(rs.next()){
                c = new Comment(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4)
                );
                commentC1.add(c);
            }
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
        
    return commentC1;
    
    }
    
     public static void insertComment(Comment commentsp1){
        try {
            Comment es1 = new Comment();
            es1=commentsp1;
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
            
            String sql = "INSERT INTO comment(memberid,cnewsid,comment1)"
                    + " VALUES(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,es1.getMemberid());
            stmt.setInt(2,es1.getCnewsid());
            stmt.setString(3,es1.getComment1());
            
            
            
            
            
            
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            stmt.close();
            conn.commit();
            conn.close();
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
    
}


