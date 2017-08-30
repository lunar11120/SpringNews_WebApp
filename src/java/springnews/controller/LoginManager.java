/*
LoginManager Controller
 */
package springnews.controller;
import java.sql.*;
import springnews.model.ConnectionDB;
import springnews.model.LoginBean;

/**
 *
 * @author amdb2
 */
public class LoginManager {
    LoginBean loginbean = new LoginBean();
    private int lv = 0;

    public LoginManager() {
    }
    
    
    public LoginManager(String user , String pass , int lv) {
        loginbean.setUsername(user);
        loginbean.setPassword(pass);
        loginbean.setLv(lv);
    }
    
public LoginManager(String user , String pass , int id,String fullname,String surname) {
        loginbean.setUsername(user);
        loginbean.setPassword(pass);
        loginbean.setLv(id);
        loginbean.setFullname(fullname);
        loginbean.setSurname(surname);
    }
    
    public LoginBean getLogin(){
        return loginbean;
    }
    
    
    //Connect hibernatedb and Validation username / password
    public boolean VerifyLogin(){
        boolean result = false;
        
        
        String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
        String dbusername = "root";
        String dbpassword = "bau5ev";
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE username = '"+
                         loginbean.getUsername()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            //Login Success Correct Username and Password
            if((rs.next())&&rs.getString(2).equals(loginbean.getPassword())){
                lv = rs.getInt(10);
                result = true;
                
            }
          
   
        } catch (Exception e) {
            System.out.println("System Fail Meaasge:"+e);
        }finally{
            try {
                if(stmt != null){stmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception e1) {
                System.out.println("Problem Close connection "+e1);
            }
        }
        
        
        return result;
    }

    public int getLv() {
        return lv;
    }
 
    public static String checkstatusLogin(String username1){
        String status001 = "";
        
        
        String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
        String dbusername = "root";
        String dbpassword = "bau5ev";
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE username = '"+
                         username1+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            //Login Success Correct Username and Password
            while(rs.next()){
                status001 = "คุณ "+rs.getString(4)+" "+rs.getString(5);
            }

          
   
        } catch (Exception e) {
            System.out.println("System Fail Meaasge:"+e);
        }finally{
            try {
                if(stmt != null){stmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception e1) {
                System.out.println("Problem Close connection "+e1);
            }
        }
        
        
        return status001;
    }
    
        public static LoginBean checkForEditLogin(String username1){
        LoginBean loginbean2 = new LoginBean();
        
        
        String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
        String dbusername = "root";
        String dbpassword = "bau5ev";
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE username = '"+
                         username1+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            //Login Success Correct Username and Password
            while(rs.next()){
                loginbean2 = new LoginBean(rs.getString(1),rs.getString(2),rs.getInt(3),
                                           rs.getString(4),rs.getString(5),
                                           rs.getString(6),rs.getString(7),
                                           rs.getString(8),rs.getString(9),rs.getInt(10));
            }

          
   
        } catch (Exception e) {
            System.out.println("System Fail Meaasge:"+e);
        }finally{
            try {
                if(stmt != null){stmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception e1) {
                System.out.println("Problem Close connection "+e1);
            }
        }
        
        
        return loginbean2;
    }

    
    

 public static int getEmpid(String uname01){
    int empid= 1;
    try {
            
            String sql005 ="SELECT id from employee WHERE username LIKE ? ";
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            
           java.sql.PreparedStatement stmt2 = conn.prepareStatement(sql005);
            stmt2.setString(1,uname01);
            
            
            
            ResultSet rs = stmt2.executeQuery();
            while (rs.next()){empid = rs.getInt(1);}
            
            
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
    
    
    return empid;
    }
 
 
 public static boolean ActiveLoginOrNot(String username01) throws ClassNotFoundException, SQLException{
        boolean result = false;
        int number1 = 0;
        
        
        String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
        String dbusername = "root";
        String dbpassword = "bau5ev";
        
        Connection conn = null;

        
     
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbusername, dbpassword);

            String sql2 = "SELECT active FROM employee WHERE username LIKE ? ";
                    
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql2);
            stmt.setString(1, username01);
            
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){number1 = rs.getInt(1);}
            
            if(number1 == 1)
            result = true;
            
            stmt.close();
            conn.close();
                

        
        return result;
    }
        
}
