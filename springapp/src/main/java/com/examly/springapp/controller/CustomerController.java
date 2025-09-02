package com.examly.springapp.controller;

import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer saved = service.createCustomer(customer);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }
}
