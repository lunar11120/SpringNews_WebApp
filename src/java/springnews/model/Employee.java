package springnews.model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amdb2
 */
public class Employee {

    static void insertEmployeeSP1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String username;
    private String password;
    private int id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String telephone;
    private String lineid;
    private String email;
    private int departmentid;
    private int active;

    public Employee(int id, String firstname, String lastname, String email,int active) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.active = active;
    }

    public Employee(String username, String password, int id, String firstname, String lastname, String telephone, String lineid, String email, int departmentid) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.lineid = lineid;
        this.email = email;
        this.departmentid = departmentid;
    }
    
    

    public Employee(String username, String password, int id, String firstname) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.firstname = firstname;
    }

    public Employee() {
    }

    public Employee(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public Employee(String username, String password, int id, String firstname, String lastname, int departmentid) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentid = departmentid;
    }
    
    
    
    

    Employee(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
    
    public static void insertEmployeeSP1(String user,String pass,int id){
        try {
             
            user ="amjunggg";
            pass ="seekj55555";
            id = 2344555;
            
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            PreparedStatement cstmt = null;
            
            System.out.println("connection pass");
//            CallableStatement cstmt = 
//                    conn.prepareCall("{call insertEmployee(?,?,?)}");
            String sql = "INSERT INTO employee(username,password,id)"
                    + " VALUES(user,pass,id)";
            
            System.out.println("sql pass");
            
            cstmt = (PreparedStatement) conn.prepareStatement(sql);
            cstmt.setString(1,user);
            cstmt.setString(2,pass);
            cstmt.setInt(3,id);
            
            
            
            cstmt.executeUpdate();
            conn.close();
            
            System.out.println("update complete");
              
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
    
    
       public static void insertEmployeeSP2(String user,String pass,int id){
        try {
             
//            String user ="amjunggg";
//            String pass ="seekj55555";
//            int id = 2344555;
            
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
            
            String sql = "INSERT INTO employee(username,password,id)"
                    + " VALUES(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            stmt.setInt(3, id);
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
       
    public static void insertEmployeeSP3(Employee emp){
        try {
             
//            String user ="amjunggg";
//            String pass ="seekj55555";
//            int id = 2344555;
            Employee es1 = new Employee();
            es1=emp;
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
            
            String sql = "INSERT INTO employee(username,password,id)"
                    + " VALUES(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,es1.getUsername());
            stmt.setString(2,es1.getPassword());
            stmt.setInt(3,es1.getId());
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
    
     public static void insertEmployeeSP4(Employee emp){
        try {
             
//            String user ="amjunggg";
//            String pass ="seekj55555";
//            int id = 2344555;
            Employee es1 = new Employee();
            es1=emp;
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
            
            String sql = "INSERT INTO employee(username,password,id,firstname,lastname,departmentid,telephone,email,lineid)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,es1.getUsername());
            stmt.setString(2,es1.getPassword());
            stmt.setInt(3,es1.getId());
            stmt.setString(4,es1.getFirstname());
            stmt.setString(5,es1.getLastname());
            stmt.setInt(6,es1.getDepartmentid());
            stmt.setString(7, es1.getTelephone());
            stmt.setString(8, es1.getEmail());
            stmt.setString(9, es1.getLineid());
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
    public static void UpdateEmployeeSP1(Employee emp,int id){
        try {
             
//            String user ="amjunggg";
//            String pass ="seekj55555";
//            int id = 2344555;
            Employee es1 = new Employee();
            es1=emp;
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            
            String sql = "UPDATE employee SET username = ?,password = ? ,id = ? , firstname = ?,lastname = ? WHERE id = ?;";
            
            String sql2 = "UPDATE employee SET username = ?,password = ? ,id = ?"
                    +" firstname = ?,lastname = ? , telephone = ?,lineid = ?,email = ?,departmentid = ? WHERE id = ?;";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,es1.getUsername());
            stmt.setString(2,es1.getPassword());
            stmt.setInt(3, es1.getId());
            stmt.setString(4, es1.getFirstname());
            stmt.setString(5, es1.getLastname());
            stmt.setInt(6, id);
   
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
    
    public static void deleteEmployeeSP4(int id){
        try {
             

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
            
            String sql = "DELETE FROM employee "
                    + " WHERE id = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("Delete Employee "+ex.getMessage());
        }
    }
    
     public static void DisableEmployee(int id){
        try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            
            String sql = "UPDATE employee SET active=0 WHERE id = ?";

            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("Delete Employee "+ex.getMessage());
        }
    }
     
     
     public static void ActiveEmployee(int id){
        try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            
            String sql = "UPDATE employee SET active=1 WHERE id = ?";

            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            
            
            int i = stmt.executeUpdate();
            System.out.println("record update ="+i);
            
            
        } catch (Exception ex) {
            System.out.println("Delete Employee "+ex.getMessage());
        }
    }
     
    public static int count_Employee_In_System(){
        int countNews = 12;
        
        
         try {
             

            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            String sql = "SELECT count(newsid) FROM employee ";
            Statement stmt = conn.createStatement();
            

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){countNews = rs.getInt(1);}
            
            

            
            
        } catch (Exception ex) {
            System.out.println("NewstitLE ERROR "+ex.getMessage());
        }
        
        
        
        return countNews;
    }
    
     public static boolean check_username_not_duplicate(String username){
         
         boolean result01 = false;
         String n1 = username;
        try {
             
            
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            
           String sql = "SELECT id from employee "
                    + " WHERE username LIKE '"+n1+"' ";
            Statement stmt = conn.createStatement();
            
            
            
            
            ResultSet rs = stmt.executeQuery(sql);
            
            int a1 = 0;

            System.out.println("record update ="+result01);
            System.out.println("record update ="+result01);
            while(rs.next()){ a1 = 1;}
            System.out.println("a1 =" +a1);
            if(a1 >= 1)
                result01 = true;
             System.out.println("record update ="+result01);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_CHECKUSER "+ex.getMessage());
        }
        return result01;
    }
     
   public static boolean isint(String x){
       try {
           Integer.parseInt(x);
           return true;
       } catch (Exception e) {
           return false;
       }
   
   
   }  
   
   
    public static boolean check_id_not_duplicate(int id){
         
         boolean result01 = false;
         int n1 = id;
        try {
             
            
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();

            
            System.out.println("connection pass");

            
           String sql = "SELECT * from employee "
                    + " WHERE id = "+n1;
            Statement stmt = conn.createStatement();
            
            
            
            
            ResultSet rs = stmt.executeQuery(sql);
            
            int a1 = 0;

            System.out.println("record update ="+result01);
            System.out.println("record update ="+result01);
            while(rs.next()){ a1 = 1;}
            System.out.println("a1 =" +a1);
            if(a1 >= 1)
                result01 = true;
             System.out.println("record update ="+result01);
            
            
        } catch (Exception ex) {
            System.out.println("EmployeeManager_CHECKUSER "+ex.getMessage());
        }
        return result01;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
}
