package com.travel.booking.userManagment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "triptekker")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Role ID", example = "1", required = true)
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(name = "Role Name", example = "admin", required = true)
    private String roleName;
}