package com.doz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean("rickAndMortyApi")
    WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

}
