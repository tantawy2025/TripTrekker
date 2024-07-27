package com.travel.booking.userManagment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Set;


@Entity
@Data
@Table(name = "user", schema = "triptekker")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Email
    @Column( nullable = false, length = 80,unique = true)
    private String email;

    @Column(nullable = false,length = 64)
    private String password;

    @Column(nullable = false,length = 20)
    private String firstName;

    @Column( nullable = false,length = 20)
    private String lastName;

    @Column( nullable = false,length = 20,unique = true)
    private String username;

    @Column( nullable = false,length = 20,unique = true)
    private String phone_number;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
