/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

import java.util.Vector;

/**
 *
 * @author amdb2
 */
public class ErrorCk {
    Vector errors;

    public ErrorCk(Vector errors) {
        this.errors = errors;
    }

    public ErrorCk() {
    }
    
    

    public Vector getErrors() {
        return errors;
    }

    public void setErrors(Vector errors) {
        this.errors = errors;
    }

    public void add(String ชื่อ_username_ไม่ถูกต้อง) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
