package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userID; // Primary key

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Integer hash;

    public UserAccount(){}

    public UserAccount(String username, Integer hash){
        this.username = username;
        this.hash = hash;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getHash() {
        return hash;
    }

    public void setHash(Integer hash) {
        this.hash = hash;
    }

}
