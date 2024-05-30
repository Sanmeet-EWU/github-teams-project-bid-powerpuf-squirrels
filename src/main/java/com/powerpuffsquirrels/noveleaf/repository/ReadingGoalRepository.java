package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReadingGoalRepository extends JpaRepository<ReadingGoal, Integer>{
    @Query("SELECT goal FROM ReadingGoal goal WHERE goal.user.userID = :userId ")
    List<ReadingGoal> findByUserId(int userId);
}
