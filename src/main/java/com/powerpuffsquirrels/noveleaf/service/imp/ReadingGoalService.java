package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.ReadingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReadingGoalService {

    private final ReadingGoalRepository repository;

    @Autowired
    public ReadingGoalService(ReadingGoalRepository repository){this.repository = repository;}

    public List<ReadingGoal> GetGoalsByUserID(int id){
       return repository.findByUserId(id);
    }

    public void updateGoals(int id, int increment){
        List<ReadingGoal> goals = GetGoalsByUserID(id);
        goals.forEach(readingGoal -> {
            if (readingGoal.getStatus().equals("Ongoing")){
                repository.IncrementBooksReadById(readingGoal.getGoalID(), increment);
                readingGoal.setBooksRead(readingGoal.getBooksRead() + increment);
            }
        });
        checkGoals(goals);
    }

    public List<ReadingGoal> checkGoals( List<ReadingGoal> goals){

        goals.forEach(readingGoal  -> {
            if(readingGoal.getStatus().equals("Ongoing") && readingGoal.getBooksRead().intValue() >= readingGoal.getTarget().intValue()){
                repository.UpdateStatusById(readingGoal.getGoalID(), "Completed");
                readingGoal.setStatus("Completed");
            }
        });

        goals.forEach(readingGoal -> {
            if(readingGoal.getStatus().equals("Ongoing") && readingGoal.getTimeLeft() < 0){
                repository.UpdateStatusById(readingGoal.getGoalID(), "Failed");
                readingGoal.setStatus("Failed"); //we don't have to re-query the db after updating it if we also update locally
            }
        });

        return goals;
    }

    public void DeleteGoal(int id){
        repository.deleteById(id);
    }


    public List<ReadingGoal> AddGoal(int numBooks, Date deadline, UserDto user){
        ReadingGoal goal = ReadingGoal.builder()
            .endDate(deadline)
            .target(numBooks)
            .booksRead(0)
            .status("Ongoing")
            .user(
                UserAccount.builder().userID(user.getUserID()).username(user.getUsername()).build()
            )
            .startDate(Date.valueOf(LocalDate.now()))
        .build();

        repository.save(goal);
        return GetGoalsByUserID(user.getUserID());
    }

}
