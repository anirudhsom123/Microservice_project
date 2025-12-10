package com.fitness.activityservice.transformer;

import com.fitness.activityservice.dto.request.ActivityRequest;
import com.fitness.activityservice.dto.response.ActivityResponse;
import com.fitness.activityservice.model.Activity;

public class ActivityTransformer {

    public static Activity activityRequestToActivity(ActivityRequest activityRequest){
        return Activity.builder()
                .userId(activityRequest.getUserId())
                .activityType(activityRequest.getActivityType())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .duration(activityRequest.getDuration())
                .startTime(activityRequest.getStartTime())
                .addtionalMetrics(activityRequest.getAddtionalMetrics())
                .build();
    }

    public static ActivityResponse activityToActivityResponse(Activity activity){
        return ActivityResponse.builder()
                .userId(activity.getUserId())
                .id(activity.getId())
                .activityType(activity.getActivityType())
                .addtionalMetrics(activity.getAddtionalMetrics())
                .updatedAt(activity.getUpdatedAt())
                .createdAt(activity.getCreatedAt())
                .caloriesBurned(activity.getCaloriesBurned())
                .duration(activity.getDuration())
                .startTime(activity.getStartTime())
                .build();
    }
}
