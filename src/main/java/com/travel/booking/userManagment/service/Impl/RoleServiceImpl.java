package com.travel.booking.userManagment.service.Impl;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.repository.RoleRepository;
import com.travel.booking.userManagment.repository.UserRepository;
import com.travel.booking.userManagment.service.RoleService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        if (roleRepository.findByRoleName(role.getRoleName()).isPresent()) {
            throw new IllegalArgumentException("Role already exists");
        }
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(()->new NoSuchElementException("Role not found"));
    }

    @Override
    public Role updateRole(Long id, Role roleDetails) {

        Role role = roleRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Role not found"));

        role.setRoleName(roleDetails.getRoleName());

        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Role not found"));

        roleRepository.delete(role);
    }

    @Override
    public Set<Role> findAllRolesByIds(List<String> roleIds) {
        Set<Long> roleLongIds = roleIds.stream()
                                        .map(Long::valueOf)
                                        .collect(Collectors.toSet());

        return roleRepository.findAllByIdIn(roleLongIds);
    }

}
