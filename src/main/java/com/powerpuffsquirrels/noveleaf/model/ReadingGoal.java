package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reading_goal")
public class ReadingGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="goal_id", nullable = false)
    private Integer goalID;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserAccount user;

    @Setter
    @Column(nullable = false)
    private Integer target;

    @Setter
    @Column(name = "start_date", nullable = false)
    private java.sql.Date   startDate;

    @Setter
    @Column(name = "end_date", nullable = false)
    private java.sql.Date   endDate;

    @Setter
    @Column(name = "books_read")
    private Integer booksRead;

    @Setter
    private String status;


    public long getTimeLeft(){
        LocalDate timeLimit = endDate.toLocalDate();
        LocalDate current = new java.util.Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.DAYS.between(current, timeLimit);
    }



}