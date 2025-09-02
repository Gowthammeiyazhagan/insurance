package com.examly.springapp.service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.exception.ValidationException;
import com.examly.springapp.model.Claim;
import com.examly.springapp.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    private final ClaimRepository repo;

    public ClaimService(ClaimRepository repo) {
        this.repo = repo;
    }

    // Create new claim
    public Claim createClaim(Claim claim) {
        return repo.save(claim);
    }

    // Get all claims
    public List<Claim> getAllClaims() {
        return repo.findAll();
    }

    // Get claim by ID
    public Claim getClaimById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
    }

    // Get all claims for a customer
    public List<Claim> getClaimsByCustomerId(Long customerId) {
        return repo.findByCustomerCustomerId(customerId);
    }

    // Update claim status
    public Claim updateClaimStatus(Long id, String status) {
        Claim claim = getClaimById(id);
        if (!List.of("SUBMITTED", "APPROVED", "REJECTED").contains(status)) {
            throw new ValidationException("Invalid claim status");
        }
        claim.setStatus(status);
        return repo.save(claim);
    }
}
