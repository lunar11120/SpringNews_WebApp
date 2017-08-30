package springnews.model;
import java.sql.*;
import java.util.*;

/**
 *
 * @author amdb2
 */
public class EmployeeManager {
    private Department dept = new Department();
    private Department dept3 = new Department();
    
    
    public Department getDepartment(){
        return dept;
    }
    public Department getDepartment3(){
        return dept3;
    }
    
    public String test(){
        return "WhAT";
    }
    
    public static ArrayList<Employee> showFirstPage_admin(){
           ArrayList<Employee> emp = new ArrayList<Employee>();
           
        try {
            
            String sql005 ="SELECT id,firstname,lastname,email from employee";
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql005);
            Employee p = null;
            while(rs.next()){
                p = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                emp.add(p);
            }
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
        
    return emp;
    
    }