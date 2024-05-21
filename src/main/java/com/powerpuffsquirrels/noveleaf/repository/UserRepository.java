package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Integer>{
    Optional<UserAccount> FindUser(String username, String password);
}
