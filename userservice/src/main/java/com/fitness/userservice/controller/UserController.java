package com.fitness.userservice.controller;

import com.fitness.userservice.dao.UserRepository;
import com.fitness.userservice.dto.request.UserRequest;
import com.fitness.userservice.dto.response.UserResponse;
import com.fitness.userservice.exceptions.UserNotFoundException;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest userRequest){
        return new ResponseEntity(userService.addUser(userRequest), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId){
        try{
            return new ResponseEntity(userService.getUser(userId),HttpStatus.OK);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable("userId") String userId){

        return ResponseEntity.ok(userService.validateUser(userId));
    }
}
