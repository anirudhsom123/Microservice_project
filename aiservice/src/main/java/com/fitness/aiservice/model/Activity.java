package com.fitness.aiservice.model;

import com.fitness.activityservice.Enum.ActivityType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {

    private String id;

    private String userId;

    private ActivityType Type;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;
    private Map<String,Object> additionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
