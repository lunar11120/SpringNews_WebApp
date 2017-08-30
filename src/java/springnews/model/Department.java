package springnews.model;
import java.util.*;
/**
 *
 * @author amdb2
 */
public class Department {
    private int departmentid;
    private String deptname;
    private String deptname_thai;
    private ArrayList<Employee> emps = new ArrayList<Employee>();

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptname_thai() {
        return deptname_thai;
    }

    public void setDeptname_thai(String deptname_thai) {
        this.deptname_thai = deptname_thai;
    }

    public ArrayList<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Employee emps) {
        this.emps.add(emps);
    }
    
    
    
    
    
}
