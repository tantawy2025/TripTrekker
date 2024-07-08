package com.travel.booking.userManagment.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "user", schema = "triptekker")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column( nullable = false, length = 80)
    private String email;

    @Column(nullable = false,length = 64)
    private String password;

    @Column(nullable = false,length = 20)
    private String firstName;

    @Column( nullable = false,length = 20)
    private String lastName;

}
