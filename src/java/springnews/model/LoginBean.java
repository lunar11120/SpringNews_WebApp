package springnews.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author amdb2
 */
public class LoginBean {
    private String username;
    private String password;
    private int id;
    private int lv;
    private String status;
    private String fullname;
    private String surname;
    private String nickname;
    private String telePhone;
    private String lineid;
    private String email;
    private int deptid;

    public LoginBean(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public LoginBean(String username, String password, int id, String fullname, String surname, String nickname, String telePhone, String lineid, String email, int deptid) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.fullname = fullname;
        this.surname = surname;
        this.nickname = nickname;
        this.telePhone = telePhone;
        this.lineid = lineid;
        this.email = email;
        this.deptid = deptid;
    }
    
    

    public LoginBean(String username, String password, int id, String fullname, String surname) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.fullname = fullname;
        this.surname = surname;
    }
    

    public LoginBean() {
    }

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public static String getEmp_name(int id){
    String empname= "-------";
    try {
            
            String sql005 ="SELECT CONCAT(firstname,' ',lastname) as name from employee WHERE id = ? ";
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            
           java.sql.PreparedStatement stmt2 = conn.prepareStatement(sql005);
            stmt2.setInt(1,id);
            
            
            
            ResultSet rs = stmt2.executeQuery();
            while (rs.next()){empname = rs.getString(1);}
            
            
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
    if(id == 0){empname= "-------";}
    
    return empname;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }
    
    
    
}
