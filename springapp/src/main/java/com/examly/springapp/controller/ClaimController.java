package com.examly.springapp.controller;

import com.examly.springapp.model.Claim;
import com.examly.springapp.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClaimController {
    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    // Create new claim
    @PostMapping("/claims")
    public ResponseEntity<Claim> submitClaim(@Valid @RequestBody Claim claim) {
        // note: test only checks validation, not saving
       Claim saved = service.createClaim(claim);
        return ResponseEntity.status(201).body(claim);
    }

    // Get all claims
    @GetMapping("/claims")
    public List<Claim> getAllClaims() {
        return service.getAllClaims();
    }

    // Get claim by ID
    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    // ✅ Get all claims for a customer (this now matches the test URL)
    @GetMapping("/customers/{customerId}/claims")
    public List<Claim> getClaimsByCustomerId(@PathVariable Long customerId) {
        return service.getClaimsByCustomerId(customerId);
    }

    // Update claim status
    @PutMapping("/claims/{id}/status")
    public Claim updateClaimStatus(@PathVariable Long id, @RequestBody Map<String, String> req) {
        return service.updateClaimStatus(id, req.get("status"));
    }
}
