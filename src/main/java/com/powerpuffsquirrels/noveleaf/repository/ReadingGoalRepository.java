package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReadingGoalRepository extends JpaRepository<ReadingGoal, Integer>{
    @Query("SELECT goal FROM ReadingGoal goal WHERE goal.user.userID = :userId ")
    List<ReadingGoal> findByUserId(int userId);

    @Modifying
    @Transactional
    @Query ("UPDATE ReadingGoal goal SET goal.status = :newStatus WHERE goal.goalID = :goalId")
    void UpdateStatusById(int goalId, String newStatus);

    @Modifying
    @Transactional
    @Query ("UPDATE ReadingGoal goal SET goal.booksRead = goal.booksRead + :increment WHERE goal.goalID = :goalId")
    void IncrementBooksReadById(int goalId, int increment);

    @Modifying
    @Transactional
    @Query ("DELETE ReadingGoal goal WHERE goal.goalID = :goalId")
    void DeleteById(int goalId);

}
