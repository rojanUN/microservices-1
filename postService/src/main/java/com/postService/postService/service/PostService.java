package com.postService.postService.service;

import com.postService.postService.dto.PostDto;
import com.postService.postService.model.Post;
import com.postService.postService.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    PostRepository postRepository;
    public void addPost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);
    }

    public List<PostDto> getPosts(){
        List<PostDto> postDtos = new ArrayList<>();
        postRepository.findAll().forEach(post -> postDtos.add(modelMapper.map(post, PostDto.class)));
        return postDtos;
    }
}
