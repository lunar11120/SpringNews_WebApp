package springnews.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author amdb2
 */
public class testConnectionBuilder {
    
    String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
    String dbusername = "root";
    String dbpassword = "bau5ev";
    
    public Connection getConnection() throws NamingException{
    Connection conn =null;
        try {
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(url, dbusername, dbpassword);
            
        } catch (Exception e) {
            System.out.println("errorrr"+e.getMessage());
        }
    
    
       
//    Class.forName("com.mysql.jdbc.Driver");
//    conn = DriverManager.getConnection(url, dbusername, dbpassword);
    
    return conn;
    }
    
}
