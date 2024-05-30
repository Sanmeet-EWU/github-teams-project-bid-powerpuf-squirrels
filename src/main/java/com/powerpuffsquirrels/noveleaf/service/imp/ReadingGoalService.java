package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import com.powerpuffsquirrels.noveleaf.repository.ReadingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingGoalService {

    private final ReadingGoalRepository repository;

    @Autowired
    public ReadingGoalService(ReadingGoalRepository repository){this.repository = repository;}

    public List<ReadingGoal> GetGoalsByUserID(int id){
       return repository.findByUserId(id);
    }


}
