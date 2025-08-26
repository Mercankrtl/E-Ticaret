// src/main/java/com/eticaret/backend/service/GenderService.java
package com.eticaret.backend.service;

import com.eticaret.backend.model.Gender;
import com.eticaret.backend.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> getAllGenders() { return genderRepository.findAll(); }
    public Optional<Gender> getGenderById(Long id) { return genderRepository.findById(id); }
    public Gender createGender(Gender gender) { return genderRepository.save(gender); }
    public Gender updateGender(Gender gender) { return genderRepository.save(gender); }
    public void deleteGender(Long id) { genderRepository.deleteById(id); }
    public Optional<Gender> getGenderByName(String name) { return genderRepository.findByName(name); }
}
