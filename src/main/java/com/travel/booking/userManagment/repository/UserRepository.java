package com.travel.booking.userManagment.repository;

import com.travel.booking.userManagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
