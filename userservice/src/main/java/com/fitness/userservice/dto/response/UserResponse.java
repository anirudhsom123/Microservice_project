package com.fitness.userservice.dto.response;

import com.fitness.userservice.ENUM.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {

    private  String id;

    private  String firstName;

    private String lastName;

    private String email;

    private  String password;

    private UserRole userRole;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;
}
