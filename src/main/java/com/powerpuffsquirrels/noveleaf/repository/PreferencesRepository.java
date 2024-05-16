package com.powerpuffsquirrels.noveleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.powerpuffsquirrels.noveleaf.model.Preferences;

public interface PreferencesRepository extends JpaRepository<Preferences, Integer>{
}
