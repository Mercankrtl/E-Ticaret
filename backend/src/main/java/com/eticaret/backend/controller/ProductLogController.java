package com.eticaret.backend.controller;

import com.eticaret.backend.model.ProductLog;
import com.eticaret.backend.service.ProductLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-logs")
public class ProductLogController {

    @Autowired
    private ProductLogService productLogService;

    // Tüm logları getir
    @GetMapping
    public List<ProductLog> getAllLogs() {
        return productLogService.getAllLogs();
    }

    // ID ile log getir
    @GetMapping("/{id}")
    public ResponseEntity<ProductLog> getLogById(@PathVariable Integer id) {
        Optional<ProductLog> log = productLogService.getLogById(id);
        return log.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni log oluştur
    @PostMapping
    public ProductLog createLog(@RequestBody ProductLog productLog) {
        return productLogService.createLog(productLog);
    }

    // Log güncelle
    @PutMapping("/{id}")
    public ResponseEntity<ProductLog> updateLog(@PathVariable Integer id, @RequestBody ProductLog logDetails) {
        Optional<ProductLog> existingLog = productLogService.getLogById(id);
        if (existingLog.isPresent()) {
            ProductLog log = existingLog.get();
            log.setUser(logDetails.getUser());
            log.setProduct(logDetails.getProduct());
            log.setAction(logDetails.getAction());
            ProductLog updatedLog = productLogService.updateLog(log);
            return ResponseEntity.ok(updatedLog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Log sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Integer id) {
        productLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
