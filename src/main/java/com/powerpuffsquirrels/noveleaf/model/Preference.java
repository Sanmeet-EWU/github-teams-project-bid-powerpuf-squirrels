package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "preference")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pref_id")
    private Integer prefID; // Primary key

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private UserAccount user;

    @ElementCollection
    @CollectionTable(name = "preferred_genres", joinColumns = @JoinColumn(name = "pref_id"))
    @Column(name = "genre")
    private List<String> preferredGenres;


    @Setter
    @Column(nullable = false, name = "pref_type")
    private String pref_type;

    @Setter
    @Column(nullable = false)
    private String value;

}