package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.DateJdbcType;

@Entity
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
    private DateJdbcType startDate;

    @Column(name = "end_date", nullable = false)
    private DateJdbcType endDate;

    @Column(name = "books_read")
    private Integer booksRead;

    private String status;

    public ReadingGoal() {}

    public ReadingGoal(Integer userID, Integer target, DateJdbcType startDate, DateJdbcType endDate){
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

    public DateJdbcType getStartDate() {
        return startDate;
    }

    public DateJdbcType getEndDate() {
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

    public void setStartDate(DateJdbcType startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(DateJdbcType endDate) {
        this.endDate = endDate;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

}
