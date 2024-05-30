package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_account")
public class UserAccount {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userID; // Primary key

    @Setter
    @Column(nullable = false)
    private String username;

    @Setter
    @Column(nullable = false)
    private String hash;

    @OneToMany(mappedBy =  "user", cascade
    = CascadeType.ALL, fetch = FetchType.LAZY)
        private Set<Preference> preferences;
}
