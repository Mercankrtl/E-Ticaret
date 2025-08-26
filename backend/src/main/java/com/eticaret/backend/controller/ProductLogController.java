package com.eticaret.backend.controller;

import com.eticaret.backend.model.ProductLog;
import com.eticaret.backend.service.ProductLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-logs")
public class ProductLogController {

    @Autowired
    private ProductLogService productLogService;

    @GetMapping("/user/{userId}")
    public List<ProductLog> getLogsByUserId(@PathVariable Long userId) {
        return productLogService.getLogsByUserId(userId);
    }
}
