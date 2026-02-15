package com.fitness.aiservice.exceptions;

public class RecommendationNotExistException extends RuntimeException{
    public RecommendationNotExistException(String message) {
        super(message);
    }
}
