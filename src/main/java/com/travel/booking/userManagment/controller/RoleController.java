package com.travel.booking.userManagment.controller;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.service.RoleService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Data
@RequestMapping("/v1/api/role")
public class RoleController {

    private final RoleService roleService;
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role newRole = roleService.createRole(role);

        return new ResponseEntity<>(role,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        Role role = roleService.getRoleById(id);

        return new ResponseEntity<>(role,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails){
        Role updatedRole = roleService.updateRole(id,roleDetails);

        return new ResponseEntity<>(updatedRole,HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find")
    public ResponseEntity<Set<Role>> findAllRolesByIds(@RequestParam List<String> roleIds) {
        Set<Role> roles = roleService.findAllRolesByIds(roleIds);
        return ResponseEntity.ok(roles);
    }


}
