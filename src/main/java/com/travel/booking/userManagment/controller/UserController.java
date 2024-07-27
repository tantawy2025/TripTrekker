package com.travel.booking.userManagment.controller;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.model.User;
import com.travel.booking.userManagment.model.request.UserRegistrationRequest;
import com.travel.booking.userManagment.service.RoleService;
import com.travel.booking.userManagment.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Data
@RequestMapping("/v1/api/auth")
@Tag(name = "USER Management APIs")
public class UserController {

    
    private final UserService userService;

    private final RoleService roleService;

    @Operation(summary = "Register new User", description = "add new user and return the created user and status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist",content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest userRequest){

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone_number(userRequest.getPhoneNumber());
        user.setUsername(userRequest.getUsername());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEnabled(true);

        Set<Role> userRequestRoles = roleService.findAllRolesByIds(userRequest.getRoles());


        userService.registerUser(user,userRequestRoles);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Operation(summary = "Disable User", description = "Disable an existing user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User disabled successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PutMapping("/disable/{userId}")
    public ResponseEntity<String> disableUser(@PathVariable String userId){

       userService.disableUser(Long.valueOf(userId));

        return ResponseEntity.ok("User registered Successfully");
    }
}
