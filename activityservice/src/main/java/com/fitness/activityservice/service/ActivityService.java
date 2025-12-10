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

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {

        Activity activity=activityRepository.save(ActivityTransformer.activityRequestToActivity(activityRequest));

        return ActivityTransformer.activityToActivityResponse(activity);
    }
}
