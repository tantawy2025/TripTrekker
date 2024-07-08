package com.travel.booking.userManagment.service;

import com.travel.booking.userManagment.model.User;
import com.travel.booking.userManagment.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }

}
