package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "reading_goal")
public class ReadingGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="goal_id", nullable = false)
    private Integer goalID;

    @Column(name = "user_id", nullable = false)
    private Integer userID;

    @Column(nullable = false)
    private Integer target;

    @Column(name = "start_date", nullable = false)
    private java.sql.Date   startDate;

    @Column(name = "end_date", nullable = false)
    private java.sql.Date   endDate;

    @Column(name = "books_read")
    private Integer booksRead;

    private String status;

/*
    public ReadingGoal() {}

    public ReadingGoal(Integer userID, Integer target, java.sql.Date   startDate, java.sql.Date   endDate){
        this.userID = userID;
        this.target = target;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getGoalID() {
        return goalID;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getTarget() {
        return target;
    }

    public java.sql.Date   getStartDate() {
        return startDate;
    }

    public java.sql.Date   getEndDate() {
        return endDate;
    }

    public Integer getBooksRead() {
        return booksRead;
    }

    public String getStatus() {
        return status;
    }

    public void setBooksRead(Integer booksRead) {
        this.booksRead = booksRead;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(java.sql.Date   startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(java.sql.Date   endDate) {
        this.endDate = endDate;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
*/

}
