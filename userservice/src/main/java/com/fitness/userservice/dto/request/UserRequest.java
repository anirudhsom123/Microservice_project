package com.fitness.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    private  String firstName;

    private String lastName;

    @NotBlank(message = "cant be blank")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "can't be blank")
    @Size(min = 6 , message = "minimum size is 6")
    private  String password;
}
