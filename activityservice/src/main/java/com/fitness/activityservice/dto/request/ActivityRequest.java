package com.fitness.activityservice.dto.request;

import com.fitness.activityservice.Enum.ActivityType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {

    private String userId;

    private ActivityType activityType;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

    private Map<String,Object> addtionalMetrics;

}
