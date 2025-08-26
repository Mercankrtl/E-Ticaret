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

    // Tüm cinsiyetleri getir
    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    // ID'ye göre cinsiyet getir
    public Optional<Gender> getGenderById(Integer id) {
        return genderRepository.findById(id);
    }

    // Yeni cinsiyet ekle
    public Gender createGender(Gender gender) {
        return genderRepository.save(gender);
    }

    // Cinsiyet güncelle
    public Gender updateGender(Gender gender) {
        return genderRepository.save(gender);
    }

    // Cinsiyet sil
    public void deleteGender(Integer id) {
        genderRepository.deleteById(id);
    }

    // İsim ile arama (opsiyonel)
    public Optional<Gender> getGenderByName(String name) {
        return genderRepository.findByName(name);
    }
}
