package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Integer authorID; // Primary key

    @Setter
    @Column(nullable = false, name="first_name")
    private String firstName;

    @Setter
    @Column(nullable = false, name="last_name")
    private String lastName;

}
