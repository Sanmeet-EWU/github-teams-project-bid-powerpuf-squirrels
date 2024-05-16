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
    private String hash;

    public UserAccount(){}

    public UserAccount(String username, String hash){
        this.username = username;
        this.hash = hash;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
