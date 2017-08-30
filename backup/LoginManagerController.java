/*
LoginManager Controller
 */
package springnews.controller;
import java.sql.*;
import springnews.model.LoginBean;

/**
 *
 * @author amdb2
 */
public class LoginManager {
    LoginBean loginbean = new LoginBean();

    public LoginManager(String user , String pass) {
        loginbean.setUsername(user);
        loginbean.setPassword(pass);
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
    
    
    
    
}
