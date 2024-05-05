package com.postService.postService.controller;

import com.postService.postService.dto.MemberDto;
import com.postService.postService.dto.PostDto;
import com.postService.postService.service.PostService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    public WebClient webClient;
    private final PostService postService;

    public PostController(PostService postService) {
        this.webClient = WebClient.create("http://localhost:8080/member/get-data");
        this.postService = postService;
    }

    @GetMapping("/get-member-data")
    public Mono<String> getMemberData() {
        return webClient.get()
                .uri("http://localhost:8080/member/get-data")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/get-data")
    public String getPostData() {
        return "this is post data";
    }

    @GetMapping("/get-all-members")
    public Mono<List<MemberDto>> getAllMembers() {
        return webClient.get().
                uri("http://10.7.1.24:8080/member/get-members")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MemberDto>>() {
                });
    }

    @PostMapping("/add-post")
    public void addPost(@RequestBody PostDto postDto) {
        postService.addPost(postDto);
    }

    @GetMapping("/get-posts")
    public List<PostDto> findMembers() {
        return postService.getPosts();
    }
}

///database haru seperate garna milena. seperate database haru am relationship haru establish nai garna mildaina

