package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
/*
@Configuration
public class WebConfiguration {

        @Bean
        public WebClient.Builder webClientBuilder() {
            return WebClient.builder();
        }

        @Bean
        public WebClient clientServiceWebClient(WebClient.Builder webClientBuilder) {
            return webClientBuilder.baseUrl("http://localhost:8085/api/clients").build();
        }

        @Bean
        public WebClient vendorServiceWebClient(WebClient.Builder webClientBuilder) {
            return webClientBuilder.baseUrl("http://localhost:8095/api/vendors").build();
        }
    }

}*/
