package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Integer authorID; // Primary key

    @Column(nullable = false, name="first_name")
    private String firstName;

    @Column(nullable = false, name="last_name")
    private String lastName;

    public Author(){}

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

}
