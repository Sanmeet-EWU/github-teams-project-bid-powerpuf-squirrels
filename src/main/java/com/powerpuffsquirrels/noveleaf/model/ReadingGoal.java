package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

import lombok.*;

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

    @Column(name = "user_id", nullable = false)
    private Integer userID;

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

}