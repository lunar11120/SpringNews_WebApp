/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author amdb2
 */
public class testLookupManager {
    public static void main(String[] args) throws SQLException {
           LookupManager lk = new LookupManager();
           System.out.println("DEPTLIST"+LookupManager.listDepartment());
    }
    
}
