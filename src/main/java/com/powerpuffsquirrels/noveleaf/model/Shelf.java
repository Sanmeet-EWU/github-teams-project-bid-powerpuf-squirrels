package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shelf_id")
    private Integer shelfID; // Primary key

    @Column(nullable = false, name="shelf_name")
    private String shelfName;

    @Column(nullable = false, name="user_id")
    private Integer userID;

    public Shelf(){}

    public Shelf(String shelfName, Integer userID){
        this.shelfName = shelfName;
        this.userID = userID;
    }

    public Integer getShelfID() {
        return shelfID;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }
}
