package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {


        @Bean
        public WebClient webClient(){

        }
        public WebClient.Builder webClientBuilder() {
            return WebClient.builder();
        }

        @Bean
        public WebClient clientServiceWebClient(WebClient.Builder webClientBuilder) {
            return webClientBuilder.baseUrl("http://client-service").build();
        }

        @Bean
        public WebClient vendorServiceWebClient(WebClient.Builder webClientBuilder) {
            return webClientBuilder.baseUrl("http://vendor-service").build();
        }
    }

}
