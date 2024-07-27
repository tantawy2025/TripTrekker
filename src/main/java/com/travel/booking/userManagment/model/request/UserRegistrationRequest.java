package com.travel.booking.userManagment.model.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class UserRegistrationRequest {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone_number;
    private List<String> roles;



}
