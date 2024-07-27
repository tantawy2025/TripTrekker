package com.travel.booking.userManagment.controller;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.model.User;
import com.travel.booking.userManagment.model.request.UserRegistrationRequest;
import com.travel.booking.userManagment.service.RoleService;
import com.travel.booking.userManagment.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Data
@RequestMapping("/v1/api/auth")
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest userRequest){

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone_number(userRequest.getPhone_number());
        user.setUsername(userRequest.getUsername());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEnabled(true);

        Set<Role> userRequestRoles = roleService.findAllRolesByIds(userRequest.getRoles());


        userService.registerUser(user,userRequestRoles);

        return ResponseEntity.ok("User registered Successfully");
    }

    @PutMapping("/disable/{userId}")
    public ResponseEntity<String> disableUser(@PathVariable String userId){

       userService.disableUser(Long.valueOf(userId));

        return ResponseEntity.ok("User registered Successfully");
    }
}
