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

    // Tüm cinsiyetleri getir
    @GetMapping
    public List<Gender> getAllGenders() {
        return genderService.getAllGenders();
    }

    // ID ile cinsiyet getir
    @GetMapping("/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable Integer id) {
        Optional<Gender> gender = genderService.getGenderById(id);
        return gender.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni cinsiyet oluştur
    @PostMapping
    public Gender createGender(@RequestBody Gender gender) {
        return genderService.createGender(gender);
    }

    // Cinsiyet güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Gender> updateGender(@PathVariable Integer id, @RequestBody Gender genderDetails) {
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

    // Cinsiyet sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Integer id) {
        genderService.deleteGender(id);
        return ResponseEntity.noContent().build();
    }
}
