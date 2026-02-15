package com.fitness.aiservice.model;

import com.fitness.activityservice.Enum.ActivityType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "recommendations")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recommendation {

    @Id
    private String id;
    private String activityId;
    private  String userId;
    private ActivityType Type;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

    @CreatedDate
    private LocalDateTime createdAt;
}
