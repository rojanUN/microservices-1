package com.postService.postService.controller;

import com.postService.postService.dto.MemberDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    public WebClient webClient;

    public PostController(){
        this.webClient = WebClient.create("http://localhost:8080/member/get-data");
    }
    @GetMapping("/get-member-data")
    public Mono<String> getMemberData(){
        return webClient.get()
                .uri("http://localhost:8080/member/get-data")
                .retrieve()
                .bodyToMono(String.class);
    }
    @GetMapping("/get-data")
    public String getPostData(){
        return "this is post data";
    }

    @GetMapping("/get-all-members")
    public Mono<List<MemberDto>> getAllMembers(){
        return webClient.get().
                uri("http://10.7.1.24:8080/member/get-members")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MemberDto>>() {
                });
    }
}



