package com.powerpuffsquirrels.noveleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.powerpuffsquirrels.noveleaf.model.Preference;

import java.util.List;

public interface PreferencesRepository extends JpaRepository<Preference, Integer> {
    List<Preference> findByUser_UserID(Integer userID);
}
