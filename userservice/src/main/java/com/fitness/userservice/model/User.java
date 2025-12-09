package com.fitness.userservice.model;

import com.fitness.userservice.ENUM.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;

    @Column
    private  String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private  String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole=UserRole.USER;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private  LocalDateTime updatedAt;




}
