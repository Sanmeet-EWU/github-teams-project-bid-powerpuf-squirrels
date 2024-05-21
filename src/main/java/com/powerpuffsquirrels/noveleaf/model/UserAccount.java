package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_account")
public class UserAccount implements UserDetails {//why not just "User"?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userID; // Primary key

    @Setter
    @Column(nullable = false)
    private String username;

    @Setter
    @Column(nullable = false)
    private String hash;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return hash;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        // Return true if the account is not expired, or false otherwise
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return true if the account is not locked, or false otherwise
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return true if the credentials are not expired, or false otherwise
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return true if the account is enabled, or false otherwise
        return true;
    }
}
