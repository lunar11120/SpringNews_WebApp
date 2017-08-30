package springnews.model;
import java.sql.*;

/**
 *
 * @author amdb2
 */
public class ConnectionDB {
    Connection conn = null;
    
    String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
    String dbusername = "root";
    String dbpassword = "bau5ev";
    
    public Connection getConnection(){
        conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbusername, dbpassword);

        } catch (ClassNotFoundException er01) {
            er01.printStackTrace();
            
        } catch (SQLException es01) {
            es01.printStackTrace();
        }
        return conn;
    
    }
    
}
