package com.memberService.memberService.controller;

import com.memberService.memberService.dto.MemberDto;
import com.memberService.memberService.dto.PostDto;
import com.memberService.memberService.service.memberService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final com.memberService.memberService.service.memberService memberService;
    public WebClient webClient;
    public MemberController(memberService memberService){
        this.webClient = WebClient.create("http://localhost:9090/post/get-data");
        this.memberService = memberService;
    }

    @GetMapping("/get-members")
    public List<MemberDto> getMemberData() {
        return memberService.getMembers();
    }
    @GetMapping("/get-post-data")
    public Mono<String> getPostData(){
        return webClient.get()
                .uri("http://localhost:9090/post/get-data")
                .retrieve()
                .bodyToMono(String.class);
    }
    @PostMapping("/save-member")
    public void addMember(@RequestBody MemberDto memberDto){
        memberService.addMember(memberDto);
    }
    @GetMapping("/get-posts")
    public Mono<List<PostDto>> getPosts(){
        return webClient.get()
                .uri("http://10.7.1.24:9090/post/get-posts")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<PostDto>>() {
                });
    }
}
