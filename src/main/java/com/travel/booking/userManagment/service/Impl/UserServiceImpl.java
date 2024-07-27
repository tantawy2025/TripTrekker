package com.travel.booking.userManagment.service.Impl;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.model.User;
import com.travel.booking.userManagment.repository.RoleRepository;
import com.travel.booking.userManagment.repository.UserRepository;
import com.travel.booking.userManagment.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public User registerUser(User user, Set<Role> roles) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new IllegalArgumentException("User Already Exist");
        }

        user.setEnabled(true);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User disableUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(false);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }


}
