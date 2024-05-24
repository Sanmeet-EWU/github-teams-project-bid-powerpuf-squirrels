package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.Preference;
import com.powerpuffsquirrels.noveleaf.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceService {

    private PreferencesRepository preferencesRepository;

    public List<Preference> getUserPreferences(int userID) {
        return preferencesRepository.findByUser_UserID(userID);
    }
}

