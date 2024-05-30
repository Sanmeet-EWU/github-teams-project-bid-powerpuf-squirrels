package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingGoalRepository extends JpaRepository<ReadingGoal, Integer>{
    List<ReadingGoal> findByUserId(int user_id);
}
