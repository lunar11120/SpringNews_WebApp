/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

/**
 *
 * @author amdb2
 */
public class SMS {
    private String username;
    private String password;
    private String form;
    private String to;
    private String message;
    private String newsid ;
    private String newstitle;

    public SMS(String username, String password, String form, String to, String message, String newsid, String newstitle) {
        this.username = username;
        this.password = password;
        this.form = form;
        this.to = to;
        this.message = message;
        this.newsid = newsid;
        this.newstitle = newstitle;
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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }
    
    
}
