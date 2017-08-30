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
public class Comment {
    private int commentid;
    private int memberid;
    private int cnewsid;
    private String comment1;

    public Comment(int commentid, int memberid, int cnewsid, String comment1) {
        this.commentid = commentid;
        this.memberid = memberid;
        this.cnewsid = cnewsid;
        this.comment1 = comment1;
    }

    public Comment(int memberid, int cnewsid, String comment1) {
        this.memberid = memberid;
        this.cnewsid = cnewsid;
        this.comment1 = comment1;
    }

    public Comment() {
    }
    
    
    
    

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public int getCnewsid() {
        return cnewsid;
    }

    public void setCnewsid(int cnewsid) {
        this.cnewsid = cnewsid;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }
    
    
    
    
}
