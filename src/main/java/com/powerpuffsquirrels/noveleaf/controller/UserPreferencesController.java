/*
package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserPreferencesDTO;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import com.powerpuffsquirrels.noveleaf.service.imp.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class UserPreferencesController {
    @Autowired
    private UserPreferenceService userPreferenceService;

    @PostMapping("/{user_id}")
    public Preference saveUserPreferences(@PathVariable Integer user_id, @RequestBody UserPreferencesDTO preferencesDTO) {
        return userPreferenceService.saveUserPreferences(user_id, preferencesDTO.getGenres(), preferencesDTO.getBookTypes(), preferencesDTO.getValue());
    }

    @GetMapping("/{user_Id}")
    public List<Preference> getUserPreferences(@PathVariable Integer userId) {
        return userPreferenceService.getUserPreferences(userId);
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<Preference> saveUserPreferences(@PathVariable Integer user_id, @RequestParam List<String> genres, @RequestParam List<String> bookTypes, @RequestParam String value) {
        UserPreferencesDTO preferencesDTO = new UserPreferencesDTO();
        preferencesDTO.setGenres(genres);
        preferencesDTO.setBookTypes(bookTypes);
        preferencesDTO.setValue(value);

        Preference savedPreference = userPreferenceService.saveUserPreferences(user_id, preferencesDTO.getGenres(), preferencesDTO.getBookTypes(), preferencesDTO.getValue());
        return new ResponseEntity<>(savedPreference, HttpStatus.CREATED);
    }

}


*/
