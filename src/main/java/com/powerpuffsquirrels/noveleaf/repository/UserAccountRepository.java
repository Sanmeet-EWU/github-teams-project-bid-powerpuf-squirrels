package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

    @Query("SELECT user FROM UserAccount user WHERE user.username = :username AND user.hash = :hash")
    UserAccount findAccount(String username, String hash);

    UserAccount findByUsername(String username);

}
