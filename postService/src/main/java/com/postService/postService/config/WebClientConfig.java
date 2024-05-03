//package com.postService.postService.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Configuration
//public class WebClientConfig {
//    @Value("postService")
//    private String serviceName;
//
//    @Bean
//    public WebClient webClient(DiscoveryClient discoveryClient){
//        ServiceInstance instance = discoveryClient.getInstances(serviceName).stream().findFirst().get();
//        String baseUrl = instance.getUri().toString();
//        return WebClient.builder()
//                .baseUrl(baseUrl)
//                .build();
//    }
//
//}
