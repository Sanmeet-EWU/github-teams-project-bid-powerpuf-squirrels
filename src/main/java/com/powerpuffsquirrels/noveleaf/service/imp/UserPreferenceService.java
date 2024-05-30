package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.Preference;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.PreferencesRepository;
import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceService {

    @Autowired
    private PreferencesRepository preferencesRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    public Preference saveUserPreferences(int userID, List<String> genres, List<String> bookTypes, String value) {
        UserAccount userAccount = userAccountRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Preference preference = Preference.builder()
                .user(userAccount)
                .preferredGenres(genres)
                .prefType(String.join(", ", bookTypes)) // Assuming a single string combining book types
                .value(value)
                .build();

        return preferencesRepository.save(preference);
    }

    public List<Preference> getUserPreferences(int userID) {
        return preferencesRepository.findByUser_UserID(userID);
    }
}
