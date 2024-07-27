package com.travel.booking.userManagment.controller;

import com.travel.booking.userManagment.model.User;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/v1/api/")
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("welcome the application up and running successfully");
    }
}
