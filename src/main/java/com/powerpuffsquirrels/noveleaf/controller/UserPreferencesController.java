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
    public ResponseEntity<Preference> saveUserPreferences(@PathVariable("user_id") Integer userId, @RequestBody UserPreferencesDTO preferencesDTO) {
        Preference savedPreference = userPreferenceService.saveUserPreferences(userId, preferencesDTO.getGenres(), preferencesDTO.getBookTypes(), preferencesDTO.getValue());
        return new ResponseEntity<>(savedPreference, HttpStatus.CREATED);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<Preference>> getUserPreferences(@PathVariable("user_id") Integer userId) {
        List<Preference> preferences = userPreferenceService.getUserPreferences(userId);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }

}



