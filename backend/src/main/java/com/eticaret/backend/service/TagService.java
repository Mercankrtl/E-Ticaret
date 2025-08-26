package com.eticaret.backend.service;

import com.eticaret.backend.model.Tag;
import com.eticaret.backend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    // Tüm tag'ları getir
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    // ID ile tag getir
    public Optional<Tag> getTagById(Integer id) {
        return tagRepository.findById(id);
    }

    // Yeni tag oluştur
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    // Tag güncelle
    public Tag updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    // Tag sil
    public void deleteTag(Integer id) {
        tagRepository.deleteById(id);
    }

    // İsme göre tag getir
    public Optional<Tag> getTagByName(String name) {
        return tagRepository.findByName(name);
    }
}
