package com.travel.booking.userManagment.service;

import com.travel.booking.userManagment.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    public Role createRole(Role role);

    public List<Role> getAllRoles();

    public Role getRoleById(Long id);

    public Role updateRole(Long id, Role roleDetails);

    public void deleteRole(Long id);

    public Set<Role> findAllRolesByIds(List<String> roleIds) ;
}
