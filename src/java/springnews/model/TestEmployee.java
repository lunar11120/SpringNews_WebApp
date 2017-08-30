/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amdb2
 */
public class TestEmployee {

    
     private int id;
     private String firstname;

    TestEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
     private final static String sql005 ="SELECT id,firstname from employee";
     
     public ArrayList<TestEmployee> showName() throws SQLException{
        ArrayList<TestEmployee> emp = null;
        ConnectionDB conndb = new ConnectionDB();
        Connection conn = conndb.getConnection();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql005);
        TestEmployee p = null;
        while(rs.next()){
            p = new TestEmployee(rs);
            if(emp == null){
                emp = new ArrayList(99);
            }
            emp.add(p);
        }
        
        
        return emp;
    
    }
     
    public TestEmployee(ResultSet rs) throws SQLException {
    this.id = rs.getInt(1);
    this.firstname = rs.getString(2);
     
     }

    @Override
    public String toString() {
        return "TestEmployee{" + "id=" + id + ", firstname=" + firstname + '}';
    }
     
    
}
