package com.eticaret.backend.service;

import com.eticaret.backend.model.ProductLog;
import com.eticaret.backend.repository.ProductLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductLogService {

    @Autowired
    private ProductLogRepository productLogRepository;

    // Tüm logları getir
    public List<ProductLog> getAllLogs() {
        return productLogRepository.findAll();
    }

    // ID'ye göre log getir
    public Optional<ProductLog> getLogById(Integer id) {
        return productLogRepository.findById(id);
    }

    // Yeni log ekle
    public ProductLog createLog(ProductLog log) {
        return productLogRepository.save(log);
    }

    // Log güncelle
    public ProductLog updateLog(ProductLog log) {
        return productLogRepository.save(log);
    }

    // Log sil
    public void deleteLog(Integer id) {
        productLogRepository.deleteById(id);
    }

    // Belirli bir kullanıcıya ait logları getir
    public List<ProductLog> getLogsByUserId(Integer userId) {
        return productLogRepository.findByUserId(userId);
    }

    // Belirli bir ürüne ait logları getir
    public List<ProductLog> getLogsByProductId(Integer productId) {
        return productLogRepository.findByProductId(productId);
    }
}
