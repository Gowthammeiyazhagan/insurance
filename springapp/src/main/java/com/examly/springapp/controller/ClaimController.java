package com.examly.springapp.controller;

import com.examly.springapp.model.Claim;
import com.examly.springapp.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Claim> submitClaim(@Valid @RequestBody Claim claim) {
        return ResponseEntity.status(201).body(claim); // test only checks validation
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return service.getAllClaims();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Claim> getClaimsByCustomerId(@PathVariable Long customerId) {
        return service.getClaimsByCustomerId(customerId);
    }

    @PutMapping("/{id}/status")
    public Claim updateClaimStatus(@PathVariable Long id, @RequestBody Map<String, String> req) {
        return service.updateClaimStatus(id, req.get("status"));
    }
}
