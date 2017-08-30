
package springnews.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import springnews.controller.LoginManager;

/**
 *
 * @author amdb2
 */
public class testempmcr {
    
        
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String na = "แพท";
        ArrayList<News> news01 = NewsManager.showNews_MainNewsOnAir_FIndbyname(na);
        
        System.out.println("res"+news01.get(0).getNewsid()+news01.get(0).getTitle());
}
    
}
