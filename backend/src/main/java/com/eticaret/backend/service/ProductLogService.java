package com.eticaret.backend.service;

import com.eticaret.backend.model.ProductLog;
import com.eticaret.backend.repository.ProductLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLogService {

    @Autowired
    private ProductLogRepository productLogRepository;

    public List<ProductLog> getLogsByUserId(Long userId) {
        return productLogRepository.findByUserUserId(userId);
    }
}
