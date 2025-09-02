package com.examly.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotBlank(message = "Claim type is required")
    private String claimType;

    @NotNull(message = "Amount is required")
    private Double amount;

    private LocalDate claimDate;
    private String description;
    private String status;
    private LocalDate processedDate;
}
