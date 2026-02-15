package com.fitness.activityservice.service;

import com.fitness.activityservice.dao.ActivityRepository;
import com.fitness.activityservice.dto.request.ActivityRequest;
import com.fitness.activityservice.dto.response.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.transformer.ActivityTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    private final KafkaTemplate<String, Activity> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;


    public ActivityResponse trackActivity(ActivityRequest activityRequest) {

         boolean isValid = userValidationService.validateUser(activityRequest.getUserId());
         System.out.println(isValid);

       if(!isValid){
           throw new RuntimeException("invaild user id" + activityRequest.getUserId());
       }

        Activity activity=activityRepository.save(ActivityTransformer.activityRequestToActivity(activityRequest));

       try{
           kafkaTemplate.send(topicName,activity.getUserId(), activity);
       }catch (Exception e){
           e.printStackTrace();
       }

        return ActivityTransformer.activityToActivityResponse(activity);
    }
}
