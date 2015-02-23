package com.risk.war.model.entities;
// Generated 18-feb-2015 18:33:03 by Hibernate Tools 3.2.2.GA


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,schema="risk_data"
)
public class User  implements Serializable {


     private String username;
     private String password;
     private String email;

    public User() {
    }

    public User(String username, String password, String email) {
       this.username = username;
       this.password = password;
       this.email = email;
    }
   
     @Id 
    
    @Column(name="username", unique=true, nullable=false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="email", nullable=false)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}

