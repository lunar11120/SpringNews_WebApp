/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author amdb2
 */
public class testdb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hibernatedb?useUnicode=true&characterEncoding=utf8";
        String dbusername = "root";
        String dbpassword = "bau5ev";
        
        Connection conn = null;
        Statement stmt = null;
        boolean result = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            System.out.println("Connection Success");
            
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE username = 'int676' ";
            ResultSet rs = stmt.executeQuery(sql);
            
            //Login Success Correct Username and Password
            if((rs.next())&&rs.getString(2).equals("dothebest")){
                result = true;
            }
   
        } catch (Exception e) {
            System.out.println("System Fail Meaasge:"+e);
    }
        
        System.out.println("result = "+result);
    
}
}
