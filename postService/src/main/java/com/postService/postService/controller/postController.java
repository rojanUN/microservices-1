package com.postService.postService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/post")
public class postController {
    public WebClient webClient;

    public postController(){
        this.webClient = WebClient.create("http://localhost:8080/member/get-data");
    }
    @GetMapping("/get-data")
    public Mono<String> getPostData(){
        return webClient.get()
                .uri("http://localhost:8080/member/get-data")
                .retrieve()
                .bodyToMono(String.class);
    }
}
