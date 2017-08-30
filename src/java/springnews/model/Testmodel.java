/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amdb2
 */
public class Testmodel {
//    public static void main(String[] args)  {
//        try {
//            String sql005 ="SELECT id,firstname from employee";
//            ConnectionDB conndb = new ConnectionDB();
//            Connection conn = conndb.getConnection();
//            
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql005);
//            
//            while(rs.next()){
//                System.out.println("id "+rs.getInt(1)+" Firstname "+rs.getString(2));
//            }
//
//            System.out.println("-----------------");
//            System.out.println("Show emp");
//        } catch (SQLException ex) {
//            Logger.getLogger(Testmodel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public static void main(String[] args) {
//         ArrayList<Employee> maintest = new ArrayList<Employee>();
//         maintest = EmployeeManager.showFirstPage_admin();
//         System.out.println("Maintest Created");
//         
//         for (int i = 0; i < maintest.size(); i++) {
//             System.out.println("co1 "+maintest.get(i).getId()+
//                     " : col2 = "+maintest.get(i).getFirstname()+
//                     " : col3 = "+maintest.get(i).getLastname()+
//                     " : col4 = "+maintest.get(i).getEmail()
//
//             );
//        }
//    }    
//    public static void main(String[] args) {
//        
//         int id = 44555;
//
//         Employee.deleteEmployeeSP4(id);
//         System.out.println("delete success");
//        
//    }
    public static int getEmpid(String uname01) {
        int empid = 1;
        try {

            String sql005 = "SELECT id from employee WHERE username LIKE ? ";
            ConnectionDB conndb = new ConnectionDB();
            Connection conn = conndb.getConnection();

            java.sql.PreparedStatement stmt2 = conn.prepareStatement(sql005);
            stmt2.setString(1, uname01);

            ResultSet rs = stmt2.executeQuery();
            while (rs.next()) {
                empid = rs.getInt(1);
            }

            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Employee Fail 001" + e.getMessage());
        }

        return empid;
    }

    public static void main(String[] args) throws SQLException {

        String username = "am001";

        Employee.check_username_not_duplicate(username);

        System.out.println("OK");

    }

}
