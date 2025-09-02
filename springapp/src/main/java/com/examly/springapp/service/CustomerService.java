package com.examly.springapp.service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
}
