package com.examly.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String phone;

    @NotBlank(message = "Policy number is required")
    private String policyNumber;
}
