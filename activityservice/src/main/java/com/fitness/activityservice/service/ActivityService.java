package com.fitness.activityservice.service;

import com.fitness.activityservice.dao.ActivityRepository;
import com.fitness.activityservice.dto.request.ActivityRequest;
import com.fitness.activityservice.dto.response.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.transformer.ActivityTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
 private final UserValidationService userValidationService;


    public ActivityResponse trackActivity(ActivityRequest activityRequest) {

         boolean isValid = userValidationService.validateUser(activityRequest.getUserId());
         System.out.println(isValid);

       if(!isValid){
           throw new RuntimeException("invaild user id" + activityRequest.getUserId());
       }

        Activity activity=activityRepository.save(ActivityTransformer.activityRequestToActivity(activityRequest));

        return ActivityTransformer.activityToActivityResponse(activity);
    }
}
