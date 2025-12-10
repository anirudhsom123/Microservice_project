package com.fitness.activityservice.dto.response;

import com.fitness.activityservice.Enum.ActivityType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ActivityResponse {

    private String id;

    private String userId;

    private ActivityType activityType;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

    private Map<String,Object> addtionalMetrics;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
