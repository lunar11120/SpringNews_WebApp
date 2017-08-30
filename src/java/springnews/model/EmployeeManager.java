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
            
            String sql005 ="SELECT id,firstname,lastname,email,active from employee";
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql005);
            Employee p = null;
            while(rs.next()){
                p = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                emp.add(p);
            }
        } catch (Exception e) {
            System.out.println("Employee Fail 001"+e.getMessage());
        }
        
        
    return emp;
    
    }
    
    public void insertEmployeeSP(){
        try {
            ArrayList<Employee> listemp = dept.getEmps();
            Employee emp = (Employee)listemp.get(0);
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            CallableStatement cstmt = 
                    conn.prepareCall("{call insertEmployee(?,?,?,?,?,?)}");
            cstmt.setInt(1,emp.getId());
            cstmt.setString(2,emp.getFirstname());
            cstmt.setString(3,emp.getLastname());
            cstmt.setString(4,emp.getNickname());
            cstmt.setString(5,emp.getTelephone());
            cstmt.setString(6,emp.getLineid());
            cstmt.execute();
            conn.close();
              
        } catch (Exception ex) {
            System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    }
    
    public void editEmployeeSP(){
        try {
            ArrayList<Employee> listemp = dept.getEmps();
            Employee emp = (Employee)listemp.get(0);
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            CallableStatement cstmt = 
                    conn.prepareCall("{call insertEmployee(?,?,?,?,?,?)}");
            cstmt.setInt(1,emp.getId());
            cstmt.setString(2,emp.getFirstname());
            cstmt.setString(3,emp.getLastname());
            cstmt.setString(4,emp.getNickname());
            cstmt.setString(5,emp.getTelephone());
            cstmt.setString(6,emp.getLineid());
            cstmt.execute();
            conn.close();
            
        } catch (Exception ex) {
             System.out.println("EmployeeManager_listEmp "+ex.getMessage());
        }
    
    }
    
    public ArrayList<Department> getAllEmployee(){
        try {
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            ArrayList<Department> listdept = new ArrayList<Department>();
            String sql = "SELECT departmentid,deptname FROM department"
                         ;
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //result of department ID and Department name
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Department dept = new Department();
                dept.setDepartmentid(rs.getInt(1));
                dept.setDeptname(rs.getString(2));
                
                String sql1 = "SELECT id,firstname,lastname FROM "+
                        "employee WHERE departmentid = "+dept.getDepartmentid()
                        ;
                Statement stmt1 = conn.prepareStatement(sql1);
                ResultSet rs1 = stmt1.executeQuery(sql1);
                
//                while(rs.next()){
//                    Employee emp = new Employee();
//                    emp.setId(rs1.getInt(1));
//                    emp.setFirstname(rs1.getString(2));
//                    emp.setLastname(rs1.getString(3));
//                    
//                    dept.setEmps(emp);
//                
//                }
                rs1.close();
                stmt1.close();
                
                listdept.add(dept);
               
            }
            rs.close();
            stmt.close();
            conn.close();
            return listdept;
            
        } catch (Exception e) {
            System.out.println("EmployeeListDept ERROR :"+e.getMessage());
            return null;
        }
    }
    
    public int deleteEmployee(int id){
        try {
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM employee where empid = "+id;
            int i = stmt.executeUpdate(sql);
            conn.close();
            return i;
            
        } catch (Exception e) {
            System.out.println("Update AND Delete error:" +e.getMessage());
            return 0;
        }
        
    }
    
    public Department getEmployee(int id){
        try {
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            
            Department dept = new Department();
            String sql = "SELECT departmentid,id,firstname,lastname FROM "+
                    "employee WHERE id = "+id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
//            if(rs.next()){
//                dept.setDepartmentid(rs.getInt(1));
//                Employee emp = new Employee();
//                emp.setId(rs.getInt(2));
//                emp.setFirstname(rs.getString(3));
//                emp.setLastname(rs.getString(4));
//                dept.setEmps(emp);
//            
//            }
            rs.close();
            stmt.close();
            conn.close();
            return dept;
            
            
            
            
        } catch (Exception e) {
            System.out.println("Get employee ERROR : "+e.getMessage());
            return null;
        }
    
    
    }
    
//   public ArrayList<Employee> getAllEmployee_reporter(){
//        try {
//            ConnectionDB condb = new ConnectionDB();
//            Connection conn = condb.getConnection();
//            ArrayList<Employee> listemp3 = new ArrayList<Employee>();
//            String sql = "SELECT id,firstname,lastname FROM employee WHERE departmentid = 3";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            
//            //result of Employee job Reporter
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()){
//                Employee emp = new Employee();
//                    emp.setId(rs.getInt(1));
//                    emp.setFirstname(rs.getString(2));
//                    emp.setLastname(rs.getString(3));
//                    dept3.setEmps(emp);
//
//               
//               
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//            return listemp3;
//            
//        } catch (Exception e) {
//            System.out.println("EmployeeListDept ERROR :"+e.getMessage());
//            return null;
//        }
//    }    
}



