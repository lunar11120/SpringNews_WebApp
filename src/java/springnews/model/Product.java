package springnews.model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amdb2
 */
public class Product {
    private int id;
    private String nickname;
    private String firstname;
    private String lastname;
    private String lineid;
    private String deptname;

    Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    
    private final static String sql ="SELECT id,nickname,firstname,lastname as name,lineid,deptname FROM employee,department" +
                               " WHERE employee.departmentid = department.departmentid"
                               + " and (firstname like ? OR lastname like ?)";
    public List<Product> findByName(String empname) throws SQLException{
        List<Product> emp = null;
        ConnectionDB conndb = new ConnectionDB();
        Connection conn = conndb.getConnection();
        
        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, firstname+"%");
        stmt.setString(2, lastname+"%");
        ResultSet rs = stmt.executeQuery();
        Product p = null;
        rs.last();
        int rows = rs.getRow();
        rs.beforeFirst();
        while(rs.next()){
            p = new Product(rs);
            if(emp == null){
                emp = new ArrayList(rows);
            }
            emp.add(p);
        }
        
        
        return emp;
    
    }
    private Product(ResultSet rs) throws SQLException{
        this.id = rs.getInt("id");
        this.firstname = rs.getString("firstname");
        this.lastname = rs.getString("lastname");
        this.deptname = rs.getString("deptname");
    
    }
}
