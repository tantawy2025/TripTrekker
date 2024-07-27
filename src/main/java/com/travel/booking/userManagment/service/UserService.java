package com.travel.booking.userManagment.service;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.model.User;
import com.travel.booking.userManagment.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {

    public User registerUser(User user, Set<Role> roles);

    public User findByUsername(String username);

    public User disableUser(Long userId);

}
