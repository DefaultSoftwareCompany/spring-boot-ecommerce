package com.dsc.controller;

import com.dsc.model.OrderedProducts;
import com.dsc.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/api/order/save")
    public ResponseEntity<OrderedProducts> save(HttpServletRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping("/api/order/get/one/{orderId}")
    public ResponseEntity<OrderedProducts> getOne(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.getByOrderId(orderId));
    }

    @GetMapping("/api/order/get/office/{officeId}")
    public ResponseEntity<List<OrderedProducts>> getByOffice(@PathVariable Short officeId) {
        return ResponseEntity.ok(service.getByOffice(officeId));
    }

    @GetMapping("/api/order/get/product/{productId}")
    public ResponseEntity<List<OrderedProducts>> getByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.getByProduct(productId));
    }

    @GetMapping("/api/order/get/customer/{customerId}")
    public ResponseEntity<List<OrderedProducts>> getByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getByCustomer(customerId));
    }
}
