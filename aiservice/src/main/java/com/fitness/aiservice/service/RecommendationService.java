package com.fitness.aiservice.service;

import com.fitness.aiservice.exceptions.RecommendationNotExistException;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.respository.RecommendationRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public List<Recommendation> getUserRecommendation(String userId) {

        return recommendationRepository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        Optional<Recommendation> optionalRecommendation=recommendationRepository.findByActivityId(activityId);
        if(optionalRecommendation.isEmpty()){
            throw new RecommendationNotExistException("Recommendation Not Exist");
        }
        return optionalRecommendation.get();
    }
}
