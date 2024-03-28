package com.springproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_table")
public class User {
    
    @Id   // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    private int id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname.trim();
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname.trim();
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        // Trim the username to remove leading and trailing spaces
        this.username = username != null ? username.trim() : null;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        // Trim the password to remove leading and trailing spaces
        this.password = password != null ? password.trim() : null;
    }
    

}
