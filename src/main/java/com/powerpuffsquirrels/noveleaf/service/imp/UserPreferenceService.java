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

    public List<Preference> getPreferencesByUserId(int userId) {
        return preferencesRepository.findByUser_UserID(userId);
    }

    public void addPreference(int userId, String prefType, String value) {
        UserAccount userAccount = userAccountRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Preference preference = Preference.builder()
                .user(userAccount)
                .prefType(prefType)
                .value(value)
                .build();
        preferencesRepository.save(preference);
    }

    public void clearPreferences(int userId, String prefType) {
        List<Preference> preferences = preferencesRepository.findByUser_UserIDAndPrefType(userId, prefType);
        preferencesRepository.deleteAll(preferences);
    }
}
