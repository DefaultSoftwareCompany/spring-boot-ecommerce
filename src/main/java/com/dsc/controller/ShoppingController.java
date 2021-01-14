package com.dsc.controller;

import com.dsc.model.Purchase;
import com.dsc.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController {
    private final ShoppingService service;

    @Autowired
    public ShoppingController(ShoppingService service) {
        this.service = service;
    }

    @PostMapping("/api/user/shopping/save")
    public ResponseEntity<Purchase> save(@ModelAttribute Purchase purchase) throws Exception {
        return ResponseEntity.ok(service.save(purchase));
    }

    @PostMapping("/api/user/shopping/{customerId}/all")
    public ResponseEntity<List<Purchase>> getAllByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getAllByCustomer(customerId));
    }

    @PostMapping("/api/user/shopping/confirm/{purchaseId}")
    public void confirm(@PathVariable Long purchaseId) {
        service.confirm(purchaseId);
    }
}
