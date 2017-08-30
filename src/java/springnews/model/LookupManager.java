package springnews.model;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author amdb2
 */
public class LookupManager {
    public static final ArrayList<Department> listDepartment(){
        try {
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            
            ArrayList<Department> listdept = new ArrayList<Department>();
            String sql = "SELECT departmentid,deptname FROM department"+
                         " WHERE departmentid >=2";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            //Create list of Department ID and DepartmentName
            while(rs.next()){
                Department dept = new Department();
                dept.setDepartmentid(rs.getInt(1));
                dept.setDeptname_thai(rs.getString(2));
                listdept.add(dept);
            }
            rs.close();
            stmt.close();
            conn.close();
            return listdept;
            
        } catch (Exception e) {
            System.out.println("LookupManager_ERROR"+e.getMessage());
            return null;
        }
        
    
    }
    public static final int getNextEmpId(){
        int empid =0;
        try {
            ConnectionDB condb = new ConnectionDB();
            Connection conn = condb.getConnection();
            
            String sql = "SELECT max(id)FROM employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                empid = rs.getInt(3);
            }
            empid++;
            rs.close();
            stmt.close();
            conn.close();
            
            
            
        } catch (Exception e) {
            System.out.println("lookupManager_nextemp_error"+e.getMessage());
        }
        return empid;
    
    }
    
}
