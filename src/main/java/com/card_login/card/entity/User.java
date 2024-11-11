package com.card_login.card.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date birthday;

    @Column(length = 20, unique = true)
    private Long phone;

    @Column
    private String privilege;

    @Column
    private boolean isLocked;

    @Column
    private String role;

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = "ROLE_USER";
        }
    }

}