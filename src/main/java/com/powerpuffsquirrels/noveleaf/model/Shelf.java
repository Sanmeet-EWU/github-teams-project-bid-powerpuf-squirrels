package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shelf_id")
    private Integer shelfID; // Primary key

    @Setter
    @Column(nullable = false, name="shelf_name")
    private String shelfName;

    @ManyToOne
    @JoinColumn(nullable = false, name="user_id", referencedColumnName = "user_id")
    private UserAccount userAccount;

}
