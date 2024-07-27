package com.travel.booking.userManagment.repository;

import com.travel.booking.userManagment.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(String roleName);

    Set<Role> findAllByIdIn(Set<Long> ids);
}
