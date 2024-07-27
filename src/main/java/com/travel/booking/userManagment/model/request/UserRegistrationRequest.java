package com.travel.booking.userManagment.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class UserRegistrationRequest {

    @Schema(name = "Username", example = "john_doe", required = true)
    private String username;

    @Schema(name = "Email", example = "john.doe@example.com", required = true)
    private String email;

    @Schema(name = "Password", example = "password123", required = true)
    private String password;

    @Schema(name = "First Name", example = "John", required = true)
    private String firstName;

    @Schema(name = "Last Name", example = "Doe", required = true)
    private String lastName;

    @Schema(name = "Phone Number", example = "+1234567890", required = true)
    private String phoneNumber;

    @Schema(name = "Roles", example = "[\"USER\", \"ADMIN\"]", required = true)
    private List<String> roles;
}
