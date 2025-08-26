// src/main/java/com/eticaret/backend/controller/GenderController.java
package com.eticaret.backend.controller;

import com.eticaret.backend.model.Gender;
import com.eticaret.backend.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public List<Gender> getAllGenders() { return genderService.getAllGenders(); }

    @GetMapping("/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable Long id) {
        Optional<Gender> gender = genderService.getGenderById(id);
        return gender.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gender createGender(@RequestBody Gender gender) { return genderService.createGender(gender); }

    @PutMapping("/{id}")
    public ResponseEntity<Gender> updateGender(@PathVariable Long id, @RequestBody Gender genderDetails) {
        Optional<Gender> existingGender = genderService.getGenderById(id);
        if (existingGender.isPresent()) {
            Gender gender = existingGender.get();
            gender.setName(genderDetails.getName());
            Gender updatedGender = genderService.updateGender(gender);
            return ResponseEntity.ok(updatedGender);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Long id) {
        genderService.deleteGender(id);
        return ResponseEntity.noContent().build();
    }
}
