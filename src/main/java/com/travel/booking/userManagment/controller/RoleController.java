package com.travel.booking.userManagment.controller;

import com.travel.booking.userManagment.model.Role;
import com.travel.booking.userManagment.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Data
@RequestMapping("/v1/api/role")
@Tag(name = "ROLE Management APIS")
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "create new role", description = "add new role and return the created role and status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist",content = @Content)
    })
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role newRole = roleService.createRole(role);

        return new ResponseEntity<>(role,HttpStatus.CREATED);
    }


    @Operation(summary = "Get all roles", description = "Returns list of roles ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }


    @Operation(summary = "Get role by id", description = "Returns role as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        Role role = roleService.getRoleById(id);

        return new ResponseEntity<>(role,HttpStatus.OK);
    }

    @Operation(summary = "update existing role by id", description = "Returns the updated role as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails){
        Role updatedRole = roleService.updateRole(id,roleDetails);

        return new ResponseEntity<>(updatedRole,HttpStatus.OK);
    }

    @Operation(summary = "delete existing role by id", description = "Returns no content ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "get all roles by existing list of ids", description = "Returns all roles as per ids givens ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @GetMapping("/find")
    public ResponseEntity<Set<Role>> findAllRolesByIds(@RequestParam List<String> roleIds) {
        Set<Role> roles = roleService.findAllRolesByIds(roleIds);
        return ResponseEntity.ok(roles);
    }


}
