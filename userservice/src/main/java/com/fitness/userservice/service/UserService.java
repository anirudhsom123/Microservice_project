package com.fitness.userservice.service;

import com.fitness.userservice.dao.UserRepository;
import com.fitness.userservice.dto.request.UserRequest;
import com.fitness.userservice.dto.response.UserResponse;
import com.fitness.userservice.exceptions.UserNotFoundException;
import com.fitness.userservice.model.User;
import com.fitness.userservice.transformer.UserTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;


    public UserResponse addUser(UserRequest userRequest) {

       User user = userRepository.save(
               UserTransformer.userRequestToUser(userRequest)
       );
       return UserTransformer.userToUserResponse(user);
    }


    public UserResponse getUser(String userId) {

        Optional<User> optionalUser=userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user don't exist");
        }

        User user=optionalUser.get();

        return UserTransformer.userToUserResponse(user);
    }

    public Boolean validateUser(String userId) {
        log.info("calling user service for {}",userId);
        return userRepository.existsById(userId);
    }
}
