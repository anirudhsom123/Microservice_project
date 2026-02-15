package com.fitness.aiservice.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Map;

@Service
public class GeminiService {
    private final WebClient webClient;

    public GeminiService(WebClient.Builder webClientBuilder){
        this.webClient=webClientBuilder.build();
    }

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String getRecommendations(String details){

        System.out.println("GeminiService working");

        Map<String, Object> requestBody=Map.of(
                "contents" ,new Object[] {
                        Map.of(
                                "parts",new Object[]{
                                        Map.of(
                                                "text",details
                                        )
                                }
                        )
                }
        );

        String response=webClient.post()
                .uri(geminiApiUrl+geminiApiKey)
                .header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(15))
                .block();

        return response;
    }

}
