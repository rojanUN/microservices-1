package com.memberService.memberService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/member")
public class MemberController {
    public WebClient webClient;
    public MemberController(){
        this.webClient = WebClient.create("http://localhost:9090/post/get-data");
    }
    @GetMapping("/get-data")
    public String getMemberData() {
        return "This is member data";
    }
    @GetMapping("/get-post-data")
    public Mono<String> getPostData(){
        return webClient.get()
                .uri("http://localhost:9090/post/get-data")
                .retrieve()
                .bodyToMono(String.class);
    }
}
