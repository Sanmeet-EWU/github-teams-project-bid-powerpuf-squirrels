package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pref_id")
    private Integer prefID; // Primary key

    @Column(nullable = false, name = "user_id")
    private Integer userID;

    @Column(nullable = false, name = "pref_type")
    private String pref_type;

    @Column(nullable = false)
    private String value;

    public Preferences() {
    }

    public Preferences(Integer userID, String pref_type, String value) {
        this.userID = userID;
        this.pref_type = pref_type;
        this.value = value;
    }

    public Integer getPrefID() {
        return prefID;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getPrefType() {
        return pref_type;
    }

    public String getValue() {
        return value;
    }

    public void setPref_type(String pref_type) {
        this.pref_type = pref_type;
    }

    public void setValue(String value) {
        this.value = value;
    }


}